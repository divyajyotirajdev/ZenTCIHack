package com.tibco.bw.palette.zendesk.design;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class Zendesk extends AbstractUIPlugin 


{

	// The plug-in ID
	public static final String PLUGIN_ID = "com.tibco.bw.palette.zendesk.design"; //$NON-NLS-1$

	// The shared instance
	private static Zendesk plugin;
	
	/**
	 * The constructor
	 */
	public Zendesk() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Zendesk getDefault() {
		return plugin;
	}
	
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public synchronized Image getImage(String path) {
		Image image = plugin.getImageRegistry().get(path);
		if (image == null) {
			ImageDescriptor desc = getImageDescriptor(path);
			if (desc != null) {
				image = desc.createImage();
				plugin.getImageRegistry().put(path, image);
			}
		}
		return image;
	}
}
