package com.musacca.accessibilityservice.interfaces;

import com.musacca.accessibilityservice.models.InnerSounds;

/**
 * Created by sotsys-014 on 5/10/16.
 */

public interface ListItemAction {
    public void onClick(InnerSounds innerSounds, int position);
}
