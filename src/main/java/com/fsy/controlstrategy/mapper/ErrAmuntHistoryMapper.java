package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.entity.ErrAmuntHistory;
import net.sf.saxon.trans.Err;

import java.util.List;

public interface ErrAmuntHistoryMapper {
    int insert(ErrAmuntHistory record);

    int insertSelective(ErrAmuntHistory record);

    void addErrHistory (ErrAmuntHistory errAmuntHistory);

    List<ErrAmuntHistory> getAllErrData();

    void delAllErrData();
}