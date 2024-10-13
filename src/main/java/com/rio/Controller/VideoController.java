package com.rio.Controller;

import com.rio.Iservices.IVideoService;
import com.rio.Service.VideoService;
import com.rio.entity.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/*"})
public class VideoController extends HttpServlet {
    private IVideoService videoService = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/videos")) {
            findAll(req, resp);
        } else if (url.contains("/admin/video/add")) {
            req.getRequestDispatcher("/views/video-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/edit")) {
            edit(req, resp);
        } else if (url.contains("/admin/video/delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/video/add")) {
            insert(req, resp);
        } else if (url.contains("/admin/video/update")) {
            update(req, resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> videos = videoService.findAll();
        req.setAttribute("videos", videos);
        req.getRequestDispatcher("/views/video-list.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("id");
        Video video = videoService.findById(videoId);
        req.setAttribute("video", video);
        req.getRequestDispatcher("/views/video-edit.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String videoId = req.getParameter("id");
        try {
            videoService.delete(videoId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/admin/videos");
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Video video = new Video();
        // Lấy dữ liệu từ form và set vào video
        // ...
        videoService.insert(video);
        resp.sendRedirect(req.getContextPath() + "/admin/videos");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String videoId = req.getParameter("videoId");
        Video video = videoService.findById(videoId);
        // Cập nhật dữ liệu từ form vào video
        // ...
        videoService.update(video);
        resp.sendRedirect(req.getContextPath() + "/admin/videos");
    }
}
