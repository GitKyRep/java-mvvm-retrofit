package com.rizkysaraan.javaretrofitmvvm.utility;

import android.content.Context;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AlertUtil {
    public static void messageDialog(Context context, String title, String message, String bt_ok, String bt_cancel, final Runnable if_ok, final Runnable if_cancel) {
        MaterialAlertDialogBuilder alert = new MaterialAlertDialogBuilder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton(bt_ok.toUpperCase(),
                (dialog, whichButton) -> {
                    if (if_ok != null) if_ok.run();
                });
        if (bt_cancel != null) {
            alert.setNegativeButton(bt_cancel.toUpperCase(),
                    (dialog, whichButton) -> {
                        if (if_cancel != null) if_cancel.run();
                    });
        }
        alert.show();
    }
}
