package com.inonitylab.viewtopdf.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by ruhul on 10/9/16.
 */

public class PermissionTaker {
    public static void PermissionTaker(Activity activity){
        int PERMISSION_ALL = 1;
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
       // ActivityCompat.requestPermissions(activity, permissions, 404);
        if(!hasPermissions(activity, permissions)){
            ActivityCompat.requestPermissions(activity, permissions, PERMISSION_ALL);
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1 && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


}
