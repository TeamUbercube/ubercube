package fr.veridiangames.core.game.entities.weapons;

import fr.veridiangames.core.game.entities.weapons.explosiveWeapons.WeaponGrenade;
import fr.veridiangames.core.game.entities.weapons.fireWeapons.WeaponAK47;
import fr.veridiangames.core.game.entities.weapons.fireWeapons.WeaponAWP;
import fr.veridiangames.core.game.entities.weapons.healthWeapon.WeaponMedicBag;
import fr.veridiangames.core.game.entities.weapons.meleeWeapon.WeaponShovel;

import java.util.concurrent.ConcurrentHashMap;

public class WeaponManager
{
	private ConcurrentHashMap<Integer, Weapon> weapons;

	public WeaponManager()
	{
		this.weapons = new ConcurrentHashMap<>();

		this.weapons.put(Weapon.AK47, new WeaponAK47());
		this.weapons.put(Weapon.AWP, new WeaponAWP());
		this.weapons.put(Weapon.GRENADE,  new WeaponGrenade(10)); //TODO modify grenade count
		this.weapons.put(Weapon.SHOVEL, new WeaponShovel());
		this.weapons.put(Weapon.MEDICBAG, new WeaponMedicBag());
	}

	public Weapon get(int id)
	{
		return weapons.get(id);
	}
}