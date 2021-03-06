/*
 * Copyright � 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.v1_7_keybind_converter.menu;

import java.awt.Dimension;
import java.io.InputStreamReader;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tk.wurst_client.v1_7_keybind_converter.Converter;
import tk.wurst_client.v1_7_keybind_converter.Main;

public class ProgressMenu extends Menu
{
	private JProgressBar progress;
	private JLabel action;
	
	public ProgressMenu()
	{
		super("Converting...", null);
		hasNavButtons = false;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		progress = new JProgressBar();
		progress.setStringPainted(false);
		progress.setPreferredSize(new Dimension(512, progress.getPreferredSize().height));
		progress.setIndeterminate(true);
		progress.setAlignmentX(CENTER_ALIGNMENT);
		add(progress);
		action = new JLabel("", JLabel.CENTER);
		action.setAlignmentX(CENTER_ALIGNMENT);
		add(action);
		new SwingWorker()
		{
			@Override
			protected Object doInBackground() throws Exception
			{
				JsonObject options = new JsonParser().parse(
					new InputStreamReader(getClass().getClassLoader()
						.getResourceAsStream(Main.RESOURCES + "options.json")))
					.getAsJsonObject().get("options").getAsJsonObject();
				new Converter(Main.instance.path, options, action).run();
				showNextMenu();
				return null;
			}
		}.execute();
	}
	
	@Override
	public void showNextMenu()
	{
		showMenu(new DoneMenu());
	}
}
