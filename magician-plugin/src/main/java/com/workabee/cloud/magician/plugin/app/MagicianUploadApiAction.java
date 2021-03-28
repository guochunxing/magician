package com.workabee.cloud.magician.plugin.app;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.workabee.cloud.magician.plugin.manger.ApiManger;
import org.jetbrains.annotations.NotNull;

/**
 * author: chunxing
 * date: 2021/3/12 10:59
 * description:
 */
public class MagicianUploadApiAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        ApiManger.uploadApi(event);
    }
}
