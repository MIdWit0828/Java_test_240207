package com.MidWit.consol.model.dao;

import com.MidWit.consol.common.IdeaCondition;
import com.MidWit.consol.model.dto.IdeaDTO;

import java.util.List;

public interface IdeaDAO {
    List<IdeaDTO> selectAllIdea();

    List<IdeaDTO> selectIdeaByCondition(IdeaCondition ideaCondition);

    Boolean insertNewIdea(IdeaDTO idea);

    Boolean updateNewIdea(IdeaDTO idea);

    Integer deleteIdea(IdeaCondition ideaCondition);
}
