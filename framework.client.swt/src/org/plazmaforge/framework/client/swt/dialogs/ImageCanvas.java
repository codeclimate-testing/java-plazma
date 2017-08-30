/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/* 
 * Created on 09.05.2009
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/** 
 * Image canvas
 * 
 * @author Oleh Hapon
 * $Id: ImageCanvas.java,v 1.3 2010/04/28 06:36:49 ohapon Exp $
 */

public class ImageCanvas extends Canvas {

    /**
     * Image
     */
    private Image image;
    
    /**
     * Paint image
     */
    private Image paintImage;
    
    /**
     * Error message
     */
    private String error;
    
    /**
     * Initialization flag
     */
    private boolean initImage;
    

    
    
    
    public ImageCanvas(Composite parent, int style) {
	super(parent, style);
	
	addPaintListener(new PaintListener() {
	    public void paintControl(PaintEvent e) {
		paintImage(e);
	    }
	});
	
    }
    
    protected void paintImage(PaintEvent e) {
	
	Rectangle rec = getClientArea();

	final int clientWidth = rec.width; // width;
	final int clientHeight = rec.height; // height;

	if (paintImage == null && !initImage) {

	    initImage = true;
	    BusyIndicator.showWhile(getShell().getDisplay(),
		    new Runnable() {
			public void run() {
			    try {
				
				if (image != null) {
				    
				    int iw = image.getImageData().width;
				    int ih = image.getImageData().height;

				    disposePaintImage();
				    
				    if (iw > clientWidth || ih > clientHeight) {
					float kx = iw / clientWidth;
					float ky = ih / clientHeight;
					float k = Math.max(kx, ky);
					if (k == 0) {
					    k = 1;
					}

					int w = (int) (iw / k);
					int h = (int) (ih / k);

					paintImage = new Image(getShell().getDisplay(), image.getImageData().scaledTo(w, h));
				    } else {
					paintImage = image;
				    }
				}
			    } catch (Throwable ex) {
				error = ex.getMessage();
				ex.printStackTrace();
			    }
			}
		    });

	}
	if (paintImage == null) {

	    e.gc.drawString(error == null ? "No image" : "Error load image: " + error, 0, 0);
	} else {
	    int x = (clientWidth - paintImage.getImageData().width) / 2;
	    int y = (clientHeight - paintImage.getImageData().height) / 2;
	    e.gc.drawImage(paintImage, x, y);
	}	
    }

    
    public Image getImage() {
	return image;
    }

    public void setImage(Image image) {
	disposeImage();
	disposePaintImage();
	initImage = false;
        this.image = image;
    }

    protected void disposePaintImage() {
	disposeImage(paintImage);
	paintImage = null;
    }


    protected void disposeImage() {
	disposeImage(image);
	image = null;
    }

    
    protected void disposeImage(Image image) {
	if (image == null) {
	    return;
	}
	image.dispose();
    }

    public void setError(String error) {
        this.error = error;
        
    }

    public void dispose () {
	if (isDisposed ()) return;
	disposeImage();
	disposePaintImage();
	super.dispose();
    }
    
    
}
