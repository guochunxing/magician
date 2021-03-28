package com.workabee.cloud.magician.plugin.manger;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.psi.PsiFile;
import com.workabee.cloud.magician.common.exception.MagicianException;
import com.workabee.cloud.magician.plugin.app.MagicianUploadApiF;
import com.workabee.cloud.magician.plugin.app.MagicianUploadApiFrom;
import com.workabee.cloud.magician.plugin.factory.ApiFactory;
import com.workabee.cloud.magician.plugin.model.SelectItem;
import com.workabee.cloud.magician.plugin.service.ApiService;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * author: chunxing
 * date: 2021/3/12 11:12
 * description:
 */
public class ApiManger {

    public static void uploadApi(AnActionEvent event) {
        try {
            DataContext context = event.getDataContext();
            PsiFile file = context.getData(LangDataKeys.PSI_FILE);
            Editor editor = context.getData(LangDataKeys.HOST_EDITOR);
            ApiService service = ApiFactory.getService(file);
            List<SelectItem> items = service.selectItems(file);
            MagicianUploadApiFrom from = new MagicianUploadApiFrom(items);
            //弹出方法选择框

            //选择方法

            //组装 api 原数据

            //上传


            SelectionModel selectionModel = Objects.requireNonNull(editor).getSelectionModel();
            String selectedText = selectionModel.getSelectedText();
            if (StringUtils.isBlank(selectedText)) {
                throw new MagicianException(100, "请选择接口方法名!");
            }


            service.collection(file, selectedText);

        } catch (Exception exception) {
            //提示
            System.err.println(exception.getMessage());
            System.err.println(exception.getStackTrace());
            //打印日志
        }
    }
}
