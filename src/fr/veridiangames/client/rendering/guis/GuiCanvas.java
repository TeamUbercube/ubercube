/*
 * Copyright (C) 2016 Team Ubercube
 *
 * This file is part of Ubercube.
 *
 *     Ubercube is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Ubercube is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Ubercube.  If not, see http://www.gnu.org/licenses/.
 */

package fr.veridiangames.client.rendering.guis;


import fr.veridiangames.client.rendering.Display;
import fr.veridiangames.client.rendering.guis.GuiComponent;
import fr.veridiangames.client.rendering.shaders.GuiShader;
import fr.veridiangames.client.rendering.shaders.Shader;
import fr.veridiangames.core.maths.Mat4;

import java.util.ArrayList;
import java.util.List;

public class GuiCanvas
{
	private List<GuiComponent> components;

	private GuiShader shader;

	public GuiCanvas() {
		shader = new GuiShader();
		components = new ArrayList<GuiComponent>();
	}
	
	public void update() {
		for (int i = 0; i < components.size(); i++) {
			if (components.get(i).isUseable())
				components.get(i).update();
		}
	}

	public void render(Display display) {
		shader.bind();
		shader.setProjectionMatrix(Mat4.orthographic(display.getWidth(), 0, 0, display.getHeight(), -1, 1));
		
		for (GuiComponent gui : components) {
			if (gui.isUseable())
				gui.renderSteps(shader);
		}
	}
	
	public void add(GuiComponent gui) {
		components.add(gui);
	}
	
	public void remove(GuiComponent gui) {
		components.remove(gui);
	}
	
	public List<GuiComponent> getComponents() {
		return components;
	}
	
	public Shader getShader() {
		return shader;
	}
}