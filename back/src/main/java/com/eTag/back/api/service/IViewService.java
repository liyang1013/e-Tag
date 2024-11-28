package com.eTag.back.api.service;

import com.eTag.back.api.pojo.View;

import java.util.List;

public interface IViewService {
    List<View> getViewByUser();
}
