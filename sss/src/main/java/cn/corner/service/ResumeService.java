package cn.corner.service;

import cn.corner.dao.ResumeDao;
import cn.corner.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-11 10:11
 */
@Service
public class ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    public void save(Resume resume){
        resumeDao.save(resume);
    }

    public void delete(Long id){
        resumeDao.deleteById(id);
    }

    public List<Resume> list(){
        return resumeDao.findAll();
    }
}
