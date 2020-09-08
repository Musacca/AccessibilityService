package com.musacca.accessibilityservice.Service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.musacca.accessibilityservice.MainActivity;
import com.musacca.accessibilityservice.controllers.WindowPositionController;

import static com.musacca.accessibilityservice.MainActivity.writer;

public class MyAccessibilityService extends AccessibilityService {
    private final AccessibilityServiceInfo info = new AccessibilityServiceInfo();
    private static final String TAG = "MyAccessibilityService";
    private static final String TAGEVENTS = "TAGEVENTS";

    private WindowPositionController windowController;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
      //  Log.d(TAG, "onAccessibilityEvent");
        if (MainActivity.isAudioRecording) {
            final String sourcePackageName = (String) accessibilityEvent.getPackageName();
            //Log.d(TAG, "accessibilityEvent.getEventType():" + accessibilityEvent.getEventType());

            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_WINDOW_STATE_CHANGED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_WINDOW_STATE_CHANGED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_VIEW_SCROLLED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_SCROLLED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "CONTENT_CHANGE_TYPE_SUBTREE", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_SUBTREE");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "CONTENT_CHANGE_TYPE_TEXT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_TEXT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.INVALID_POSITION) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "INVALID_POSITION", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "INVALID_POSITION");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.CONTENT_CHANGE_TYPE_UNDEFINED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "CONTENT_CHANGE_TYPE_UNDEFINED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "CONTENT_CHANGE_TYPE_UNDEFINED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_ANNOUNCEMENT) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_ANNOUNCEMENT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_ANNOUNCEMENT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_ASSIST_READING_CONTEXT", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_ASSIST_READING_CONTEXT");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_GESTURE_DETECTION_END) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_GESTURE_DETECTION_END", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_GESTURE_DETECTION_END");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_VIEW_CLICKED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_CLICKED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_TOUCH_EXPLORATION_GESTURE_START", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_GESTURE_DETECTION_START) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_GESTURE_DETECTION_START", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_GESTURE_DETECTION_START");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_VIEW_ACCESSIBILITY_FOCUSED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
            }
            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_WINDOWS_CHANGED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_WINDOWS_CHANGED", accessibilityEvent.getEventType() + ""});

                Log.d(TAGEVENTS, "TYPE_WINDOWS_CHANGED");
            }

            if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {
                writer.writeNext(new String[]{"" + "", sourcePackageName, "TYPE_VIEW_TEXT_CHANGED", accessibilityEvent.getEventType() + ""});
            }
        }
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