package com.MidWit.consol.model.service;

import com.MidWit.consol.common.IdeaCondition;
import com.MidWit.consol.model.dao.IdeaDAO;
import com.MidWit.consol.model.dto.IdeaDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.MidWit.consol.common.Template.getSession;

public class IdeaService {
    IdeaDAO dao;
    public List<IdeaDTO> selectAllIdea() {
        SqlSession session = getSession();
        dao = session.getMapper(IdeaDAO.class);

        List<IdeaDTO> ideaList = dao.selectAllIdea();
        if (ideaList != null && !ideaList.isEmpty()) {
            session.commit();
        } else {
            session.rollback();
        }

        session.close();
        return ideaList;
    }

    public List<IdeaDTO> selectIdeaByCondition(IdeaCondition ideaCondition) {
        SqlSession session = getSession();
        dao = session.getMapper(IdeaDAO.class);

        List<IdeaDTO> ideaList = dao.selectIdeaByCondition(ideaCondition);

        if (ideaList != null && !ideaList.isEmpty()) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();
        return ideaList;
    }

    public boolean insertNewIdea(IdeaDTO idea) {
        SqlSession session = getSession();
        dao = session.getMapper(IdeaDAO.class);

        Boolean isSuccess = dao.insertNewIdea(idea);
        if (isSuccess) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();

        return isSuccess;
    }

    public boolean updateIdea(IdeaDTO idea) {
        SqlSession session = getSession();
        dao = session.getMapper(IdeaDAO.class);

        Boolean isSuccess = dao.updateNewIdea(idea);
        if (isSuccess) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();
        return isSuccess;
    }

    public int deleteIdea(IdeaCondition ideaCondition) {
        SqlSession session = getSession();
        dao = session.getMapper(IdeaDAO.class);

        Integer result = dao.deleteIdea(ideaCondition);
        if (result > 0) {
           session.commit();
        } else {
            session.rollback();
        }
        session.close();
        return result;
    }
}
