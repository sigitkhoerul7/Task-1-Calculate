package com.example.sigit.calculate;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by sigit on 05/07/17.
 */

public class Keypad extends InputMethodService implements KeyboardView.OnKeyboardActionListener{

    Activity target;

    public Keypad(Activity target) {
        this.target = target;
    }

    public void onKey(int primaryCode, int[]keyCode){
        long evenTime = System.currentTimeMillis();
        KeyEvent event = new KeyEvent(evenTime,evenTime,KeyEvent.ACTION_DOWN, primaryCode, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE);
        target.dispatchKeyEvent(event);
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }


}

