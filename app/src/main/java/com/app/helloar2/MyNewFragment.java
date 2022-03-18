package com.app.helloar2;

import android.content.Context;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;

public class MyNewFragment extends ArFragment {
    interface OnCompleteListener {
        public abstract void onComplete();
    }

    private OnCompleteListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (OnCompleteListener) context;
        } catch (final ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ");
        }
    }


    @Override
    protected Config getSessionConfiguration(Session session) {
        //Update session config...
        mListener.onComplete();
        return super.getSessionConfiguration(session);
    }

}