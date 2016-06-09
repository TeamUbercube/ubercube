/*
 *   Copyright (C) 2016 Team Ubercube
 *
 *   This file is part of Ubercube.
 *
 *       Ubercube is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       Ubercube is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU General Public License for more details.
 *
 *       You should have received a copy of the GNU General Public License
 *       along with Ubercube.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.veridiangames.core.game.entities.components;

import fr.veridiangames.core.GameCore;
import fr.veridiangames.core.game.entities.weapons.Weapon;
import fr.veridiangames.core.maths.Transform;

/**
 * Created by Marccspro on 7 f�vr. 2016.
 */
public class ECWeapon extends EComponent
{
	private int weaponID;
	private Weapon weapon;
	
	public ECWeapon(int weapon)
	{
		super(WEAPON);
		super.addDependencies(RENDER);
		this.weaponID = weapon;
	}
	
	public void init(GameCore core)
	{
		try
		{
			this.weapon = Weapon.weapons.get(weaponID).newInstance();
			Transform parentTransform = ((ECRender) this.parent.get(RENDER)).getEyeTransform();
			this.weapon.getTransform().setParent(parentTransform);
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
	
	public void update(GameCore core)
	{
		weapon.update(core);
	}
	
	public int getWeaponID()
	{
		return weaponID;
	}
	
	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(int weapon)
	{
		try
		{
			this.weaponID = weapon;
			this.weapon = Weapon.weapons.get(weapon).newInstance();
			Transform parentTransform = ((ECRender) this.parent.get(RENDER)).getTransform();
			this.weapon.getTransform().setParent(parentTransform);
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
