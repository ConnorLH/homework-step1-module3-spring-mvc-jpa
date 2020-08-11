package cn.corner.dao;

import cn.corner.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-11 10:07
 */
public interface ResumeDao extends JpaRepository<Resume,Long>, JpaSpecificationExecutor<Resume> {
}
