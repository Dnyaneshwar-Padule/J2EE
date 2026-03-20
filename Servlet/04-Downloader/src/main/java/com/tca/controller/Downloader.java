package com.tca.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@WebServlet("/download")
public class Downloader extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("option");
        ServletContext context = getServletContext();

        String filePath = null;

        if ("image".equals(option)) {
            filePath = "/resources/image.jpg";
        } else if ("pdf".equals(option)) {
            filePath = "/resources/file.pdf";
        } else if ("video".equals(option)) {
            filePath = "/resources/video.mp4";
        }

        if (filePath == null) {
        	request.getRequestDispatcher("index.jsp").forward(request, response);
            //response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid option");
            return;
        }

        InputStream in = context.getResourceAsStream(filePath);

        if (in == null) {
        	System.out.println("Input Stream is null !");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	return;
        }

        String mimeType = context.getMimeType(filePath);
        //System.out.println("MIME TYPE: " + mimeType);
        
        response.setContentType(mimeType);

        // Forces Download  {Content-Disposition: attachment; filename='filename'}
        //response.setHeader("Content-Disposition",
          //      "attachment; filename=\"" + filePath.substring(filePath.lastIndexOf("/") + 1) + "\"");

        
        OutputStream out = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.flush();
        out.close();
    }
}
