package com.musacca.accessibilityservice.Service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.RequiresApi;

import com.musacca.accessibilityservice.MainActivity;
import com.musacca.accessibilityservice.controllers.WindowPositionController;

import static com.musacca.accessibilityservice.MainActivity.writer;

public class MyAccessibilityService extends AccessibilityService {
    private final AccessibilityServiceInfo info = new AccessibilityServiceInfo();
    private static final String TAG = "MyAccessibilityService";
    private static final String TAGEVENTS = "TAGEVENTS";
    private String currntApplicationPackage = "";

    private WindowPositionController windowController;
    private WindowManager windowManager;
    private boolean showWindow = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
//        Log.d(TAG, "onAccessibilityEvent");
        if (MainActivity.isAudioRecording) {
            final String sourcePackageName = (String) accessibilityEvent.getPackageName();
            //Log.d(TAG, "accessibilityEvent.getEventType():" + accessibilityEvent.getEventType());


            windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_WINDOW_STATE_CHANGED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_WINDOW_STATE_CHANGED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_VIEW_SCROLLED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_SCROLLED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "CONTENT_CHANGE_TYPE_SUBTREE", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_SUBTREE");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "CONTENT_CHANGE_TYPE_TEXT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_TEXT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.INVALID_POSITION) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "INVALID_POSITION", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "INVALID_POSITION");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_UNDEFINED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "CONTENT_CHANGE_TYPE_UNDEFINED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_UNDEFINED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_ANNOUNCEMENT) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_ANNOUNCEMENT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_ANNOUNCEMENT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_ASSIST_READING_CONTEXT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_ASSIST_READING_CONTEXT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_GESTURE_DETECTION_END) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_GESTURE_DETECTION_END", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_GESTURE_DETECTION_END");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_VIEW_CLICKED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_CLICKED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_TOUCH_EXPLORATION_GESTURE_START", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_GESTURE_DETECTION_START) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_GESTURE_DETECTION_START", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_GESTURE_DETECTION_START");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_VIEW_ACCESSIBILITY_FOCUSED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOWS_CHANGED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_WINDOWS_CHANGED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_WINDOWS_CHANGED");
            }

            if (accessibilityEvent.getPackageName() == null || !(accessibilityEvent.getPackageName().equals("com.bsb.hike") || !(accessibilityEvent.getPackageName().equals("com.whatsapp") || accessibilityEvent.getPackageName().equals("com.facebook.orca") || accessibilityEvent.getPackageName().equals("com.twitter.android") || accessibilityEvent.getPackageName().equals("com.facebook.katana") || accessibilityEvent.getPackageName().equals("com.facebook.lite"))))
                showWindow = false;

            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {
                writer.writeNext(new String[]{java.time.Clock.systemUTC().instant() + "", sourcePackageName, "TYPE_VIEW_TEXT_CHANGED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_TEXT_CHANGED");
                if (windowController == null)
                    windowController = new WindowPositionController(windowManager, getApplicationContext());
                showWindow = true;
                windowController.notifyDatasetChanged(accessibilityEvent.getText().toString(), currntApplicationPackage);
            }
        }
//        } else if(accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED){
//            Log.d(TAGEVENTS, "TYPE_WINDOW_STATE_CHANGED:"+accessibilityEvent.getContentDescription());
//
////            if (accessibilityEvent.getPackageName().equals("com.whatsapp") && (accessibilityEvent.getContentDescription() == null || !accessibilityEvent.getContentDescription().equals("Type a message")))
////                showWindow = false;
////            if (accessibilityEvent.getPackageName().equals("com.facebook.katana") && (accessibilityEvent.getText().toString().equals("[What's on your mind?]") || accessibilityEvent.getText().toString().equals("[Search]")))
////                showWindow = false;
////            if (accessibilityEvent.getPackageName().equals("com.twitter.android") && (accessibilityEvent.getText().toString().equals("[What\u2019s happening?]") || accessibilityEvent.getText().toString().equals("[Search Twitter]")))
////                showWindow = false;
//            if (accessibilityEvent.getContentDescription()!=null && (accessibilityEvent.getContentDescription().toString().equals("Textbox in chat thread")))
//                showWindow = true;
//
//
//            //remove window when keyboard closed or user moved from chatting to other things
//            if (windowController != null && !showWindow)
//                windowController.onDestroy();
//        }

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onServiceConnected() {
        // Set the type of events that this service wants to listen to.
        //Others won't be passed to this service.
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.notificationTimeout = 100;

        this.setServiceInfo(info);
    }

    /**
     * Check if Accessibility Service is enabled.
     *
     * @param mContext
     * @return <code>true</code> if Accessibility Service is ON, otherwise <code>false</code>
     */

}