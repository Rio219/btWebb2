package com.rio.Service;

import java.util.List;

import com.rio.Dao.VideoDao;
import com.rio.Idao.IVideoDao;
import com.rio.Iservices.IVideoService;
import com.rio.entity.Video;

public class VideoService implements IVideoService {

    IVideoDao videoDao = new VideoDao();

    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void delete(String videoId) throws Exception {
        videoDao.delete(videoId);
    }

    @Override
    public Video findById(String videoId) {
        return videoDao.findById(videoId);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }
}
