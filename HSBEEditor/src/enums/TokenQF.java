package enums;

import interfaces.Token;

/**
 * All possible Quick Functions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenQF implements Token {

	GETBARTMP(TokenQFCaller.NOTHING, "GetBarTmp", ReturnType.FLOAT),
	GETBARTMP2(TokenQFCaller.NOTHING, "GetBarTmp2", ReturnType.FLOAT),
	GETBARMIN(TokenQFCaller.NOTHING, "GetBarMin", ReturnType.FLOAT),
	GETBARMAX(TokenQFCaller.NOTHING, "GetBarMax", ReturnType.FLOAT),
	GETBARVAL(TokenQFCaller.NOTHING, "GetBarVal", ReturnType.FLOAT),
	GETBARFRAC(TokenQFCaller.NOTHING, "GetBarFrac", ReturnType.FLOAT),
	GETBARVIS(TokenQFCaller.NOTHING, "GetBarVis", ReturnType.FLOAT),
	SEPAR____1(null," ",null),
	
	GETDAYOFWEEK (TokenQFCaller.NOTHING, "GetDayOfWeek", ReturnType.RANGE_0_6),
	GAMEDAY (TokenQFCaller.NOTHING, "GameDay", ReturnType.RANGE_0_31),
	GAMEHOUR (TokenQFCaller.NOTHING, "GameHour", ReturnType.RANGE_0_24),
	REALHOUR (TokenQFCaller.NOTHING, "RealHour", ReturnType.RANGE_0_24),
	GETQUESTKEYPRESSED (TokenQFCaller.NOTHING, "GetQuestKeyPressed", ReturnType.BOOL),
	ISKEYPRESSED2 (TokenQFCaller.NOTHING, "IsKeyPressed2", ReturnType.BOOL, TokenQFParam.DX_KEYCODE2),
	ISKEYPRESSED3 (TokenQFCaller.NOTHING, "IsKeyPressed3", ReturnType.BOOL, TokenQFParam.DX_KEYCODE3),
	ISCONTROLPRESSED (TokenQFCaller.NOTHING, "IsControlPressed", ReturnType.BOOL, TokenQFParam.CONTROL_CODE),
	GETBREATHISVISIBLE (TokenQFCaller.NOTHING, "GetBreathIsVisible", ReturnType.BOOL),
	GETFPS (TokenQFCaller.NOTHING, "GetFPS", ReturnType.INT),
	GETPLAYERKNOWSENEMY (TokenQFCaller.NOTHING, "GetPlayerKnowsEnemy", ReturnType.BOOL),
	SEPAR____2(null," ",null),
	
	GETLEVEL (TokenQFCaller.ACTOR, "GetLevel", ReturnType.INT),
	GETHEALTHCUR (TokenQFCaller.ACTOR, "GetHealthCur", ReturnType.FLOAT),
	GETHEALTHMAX (TokenQFCaller.ACTOR, "GetHealthMax", ReturnType.FLOAT),
	GETHEALTHMAX2 (TokenQFCaller.ACTOR, "GetHealthMax2", ReturnType.FLOAT),
	GETMAGICKACUR (TokenQFCaller.ACTOR, "GetMagickaCur", ReturnType.FLOAT),
	GETMAGICKAMAX (TokenQFCaller.ACTOR, "GetMagickaMax", ReturnType.FLOAT),
	GETMAGICKAMAX2 (TokenQFCaller.ACTOR, "GetMagickaMax2", ReturnType.FLOAT),
	GETFATIGUECUR (TokenQFCaller.ACTOR, "GetFatigueCur", ReturnType.FLOAT),
	GETFATIGUEMAX (TokenQFCaller.ACTOR, "GetFatigueMax", ReturnType.FLOAT),
	GETFATIGUEMAX2 (TokenQFCaller.ACTOR, "GetFatigueMax2", ReturnType.FLOAT),
	GETENCUMBRANCECUR (TokenQFCaller.ACTOR, "GetEncumbranceCur", ReturnType.FLOAT),
	GETENCUMBRANCEMAX (TokenQFCaller.ACTOR, "GetEncumbranceMax", ReturnType.FLOAT),
	GETBREATHCUR (TokenQFCaller.ACTOR, "GetBreathCur", ReturnType.FLOAT),
	GETBREATHMAX (TokenQFCaller.ACTOR, "GetBreathMax", ReturnType.FLOAT),
	GETBOUNTY (TokenQFCaller.ACTOR, "GetBounty", ReturnType.INT),
	GETACTORLIGHTAMOUNT (TokenQFCaller.ACTOR, "GetActorLightAmount", ReturnType.RANGE_0_100),
	GETSPELLEFFECTIVENESS (TokenQFCaller.ACTOR, "GetSpellEffectiveness", ReturnType.RANGE_0_100),
	GETSOULLEVEL (TokenQFCaller.ACTOR, "GetSoulLevel", ReturnType.RANGE_0_5),
	ISENEMY (TokenQFCaller.ACTOR, "IsEnemy", ReturnType.BOOL),
	ISINCOMBAT (TokenQFCaller.ACTOR, "IsInCombat", ReturnType.BOOL),
	ISWEAPONOUT (TokenQFCaller.ACTOR, "IsWeaponOut", ReturnType.BOOL),
	ISSHIELDOUT (TokenQFCaller.ACTOR, "IsShieldOut", ReturnType.BOOL),
	ISTORCHOUT (TokenQFCaller.ACTOR, "IsTorchOut", ReturnType.BOOL),
	ISSNEAKING (TokenQFCaller.ACTOR, "IsSneaking", ReturnType.BOOL),
	ISRUNNING (TokenQFCaller.ACTOR, "IsRunning", ReturnType.BOOL),
	ISRIDINGHORSE (TokenQFCaller.ACTOR, "IsRidingHorse", ReturnType.BOOL),
	ISSWIMMING (TokenQFCaller.ACTOR, "IsSwimming", ReturnType.BOOL),
	ISUNDERWATER (TokenQFCaller.ACTOR, "IsUnderWater", ReturnType.BOOL),
	ISPOISONED (TokenQFCaller.ACTOR, "IsPoisoned", ReturnType.BOOL),
	GETWOUNDED (TokenQFCaller.ACTOR, "GetWounded", ReturnType.BOOL, TokenQFParam.HEALTH_FRAC),
	GETDEAD (TokenQFCaller.ACTOR, "GetDead", ReturnType.BOOL),
	GETDISABLED (TokenQFCaller.ACTOR, "GetDisabled", ReturnType.BOOL),
	GETARMORRATING (TokenQFCaller.ACTOR, "GetArmorRating", ReturnType.FLOAT),
	GETARMORERMULT (TokenQFCaller.ACTOR, "GetArmorerMult", ReturnType.ARMORER),
	GETHORSE (TokenQFCaller.ACTOR, "GetHorse", ReturnType.REF),
	SEPAR____3(null," ",null),
	
	GETGOLD (TokenQFCaller.ACTOR, "GetGold", ReturnType.INT),
	GETLOCKPICKS (TokenQFCaller.ACTOR, "GetLockpicks", ReturnType.INT),
	GETREPAIRHAMMERS (TokenQFCaller.ACTOR, "GetRepairHammers", ReturnType.INT),
	GETVARLASTONES (TokenQFCaller.ACTOR, "GetVarlaStones", ReturnType.INT),
	GETWELKNDSTONES (TokenQFCaller.ACTOR, "GetWelkyndStones", ReturnType.INT),
	SEPAR____4(null," ",null),
	
	GETAVC (TokenQFCaller.ACTOR, "GetAVC", ReturnType.FLOAT, TokenQFParam.AV_CODE),
	GETMAXAVC (TokenQFCaller.ACTOR, "GetMaxAVC", ReturnType.FLOAT, TokenQFParam.AV_CODE),
	GETAVMODC (TokenQFCaller.ACTOR, "GetAVModC", ReturnType.FLOAT, TokenQFParam.AV_CODE),
	GETAVRESISTNORMALWEAPONS (TokenQFCaller.ACTOR, "GetAVResistNormalWeapons", ReturnType.FLOAT),
	GETAVRESISTMAGIC (TokenQFCaller.ACTOR, "GetAVResistMagic", ReturnType.FLOAT),
	GETAVRESISTFIRE (TokenQFCaller.ACTOR, "GetAVResistFire", ReturnType.FLOAT),
	GETAVRESISTFROST (TokenQFCaller.ACTOR, "GetAVResistFrost", ReturnType.FLOAT),
	GETAVRESISTSHOCK (TokenQFCaller.ACTOR, "GetAVResistShock", ReturnType.FLOAT),
	GETAVRESISTPARALYSIS (TokenQFCaller.ACTOR, "GetAVResistParalysis", ReturnType.FLOAT),
	GETAVRESISTPOISON (TokenQFCaller.ACTOR, "GetAVResistPoison", ReturnType.FLOAT),
	GETAVRESISTDISEASE (TokenQFCaller.ACTOR, "GetAVResistDisease", ReturnType.FLOAT),
	GETAVREFLECTDAMAGE (TokenQFCaller.ACTOR, "GetAVReflectDamage", ReturnType.FLOAT),
	GETAVSPELLREFLECTCHANCE (TokenQFCaller.ACTOR, "GetAVSpellReflectChance", ReturnType.FLOAT),
	GETAVSPELLABSORBCHANCE (TokenQFCaller.ACTOR, "GetAVSpellAbsorbChance", ReturnType.FLOAT),
	GETAVDETECTLIFE (TokenQFCaller.ACTOR, "GetAVDetectLife", ReturnType.FLOAT),
	GETAVNIGHTEYE (TokenQFCaller.ACTOR, "GetAVNightEye", ReturnType.INT),
	GETAVSILENCED (TokenQFCaller.ACTOR, "GetAVSilenced", ReturnType.BOOL),
	GETAVPARALIZED (TokenQFCaller.ACTOR, "GetAVParalized", ReturnType.BOOL),
	SEPAR____5(null," ",null),

	GETOBJECTHEALTH (TokenQFCaller.ITEM, "GetObjectHealth", ReturnType.FLOAT),
	GETOBJECTCHARGE (TokenQFCaller.WEAPON, "GetObjectCharge", ReturnType.FLOAT),
	GETATTACKDAMAGE (TokenQFCaller.ACTOR_OR_WEAPON, "GetAttackDamage", ReturnType.FLOAT),
	GETENCHANTMENT (TokenQFCaller.ITEM, "GetEnchantment", ReturnType.REF),
	GETARMORAR (TokenQFCaller.ARMOR, "GetArmorAR", ReturnType.FLOAT),
	GETOBJECTVALUE (TokenQFCaller.ACTOR_OR_ITEM, "GetObjectValue", ReturnType.MULTI, TokenQFParam.VALUE_CODE_D),
	GETCURRENTVALUE (TokenQFCaller.ACTOR_OR_ITEM, "GetCurrentValue", ReturnType.MULTI, TokenQFParam.VALUE_CODE_D),
	GETEQUIPPEDOBJECTVALUE (TokenQFCaller.ACTOR, "GetEquippedObjectValue", ReturnType.MULTI, TokenQFParam.VALUE_CODE_D, TokenQFParam.SLOT_CODE_D),
	GETEQUIPPEDCURRENTVALUE (TokenQFCaller.ACTOR, "GetEquippedCurrentValue", ReturnType.MULTI, TokenQFParam.VALUE_CODE_D, TokenQFParam.SLOT_CODE_D),
	GETEQUIPPEDOBJECT (TokenQFCaller.ACTOR, "GetEquippedObject", ReturnType.REF, TokenQFParam.SLOT_CODE),
	GETITEMCOUNT (TokenQFCaller.ITEM, "GetItemCount", ReturnType.INT),
	GETITEMCOUNTPARAM (TokenQFCaller.ACTOR, "GetItemCountParam", ReturnType.INT, TokenQFParam.ITEM),
	SEPAR____6(null," ",null),

	GETWEAPON (TokenQFCaller.ACTOR, "GetWeapon", ReturnType.REF),
	GETWEAPONFISTS (TokenQFCaller.ACTOR, "GetWeaponFists", ReturnType.REF),
	GETWEAPONHEALTHCUR (TokenQFCaller.ACTOR, "GetWeaponHealthCur", ReturnType.FLOAT),
	GETWEAPONHEALTHMAX (TokenQFCaller.ACTOR, "GetWeaponHealthMax", ReturnType.FLOAT),
	GETWEAPONHEALTHMAXARMORER (TokenQFCaller.ACTOR, "GetWeaponHealthMaxArmorer", ReturnType.FLOAT),
	GETWEAPONCHARGECUR (TokenQFCaller.ACTOR, "GetWeaponChargeCur", ReturnType.FLOAT),
	GETWEAPONCHARGEMAX (TokenQFCaller.ACTOR, "GetWeaponChargeMax", ReturnType.FLOAT),
	GETWEAPONPOISON (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponPoison", ReturnType.REF),
	GETWEAPONTYPE (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponType", ReturnType.RANGE_0_5),
	GETWEAPONISTYPE (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponIsType", ReturnType.BOOL, TokenQFParam.WEAPON_TYPE),
	GETWEAPONISBLADE (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponIsBlade", ReturnType.BOOL),
	GETWEAPONISBLUNT (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponIsBlunt", ReturnType.BOOL),
	GETWEAPONISMELEE (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponIsMelee", ReturnType.BOOL),
	GETWEAPONIS2HANDED (TokenQFCaller.ACTOR_OR_WEAPON, "GetWeaponIs2Handed", ReturnType.BOOL),
	GETAMMO (TokenQFCaller.ACTOR, "GetAmmo", ReturnType.REF),
	GETSHIELD (TokenQFCaller.ACTOR, "GetShield", ReturnType.REF),
	GETSHIELDHEALTHCUR (TokenQFCaller.ACTOR, "GetShieldHealthCur", ReturnType.FLOAT),
	GETSHIELDHEALTHMAX (TokenQFCaller.ACTOR, "GetShieldHealthMax", ReturnType.FLOAT),
	GETSHIELDHEALTHMAXARMORER (TokenQFCaller.ACTOR, "GetShieldHealthMaxArmorer", ReturnType.FLOAT),
	GETTORCH (TokenQFCaller.ACTOR, "GetTorch", ReturnType.REF),
	GETTORCHTIMELEFT (TokenQFCaller.ACTOR_OR_LIGHT, "GetTorchTimeLeft", ReturnType.FLOAT),
	GETTORCHTIMEMAX (TokenQFCaller.ACTOR_OR_LIGHT, "GetTorchTimeMax", ReturnType.FLOAT),
	SEPAR____7(null," ",null),

	GETARMORHEALTHCUR (TokenQFCaller.ACTOR, "GetArmorHealthCur", ReturnType.FLOAT),
	GETARMORHEALTHMAX (TokenQFCaller.ACTOR, "GetArmorHealthMax", ReturnType.FLOAT),
	GETARMORHEALTHMAXARMORER (TokenQFCaller.ACTOR, "GetArmorHealthMaxArmorer", ReturnType.FLOAT),
	GETARMORSHIELDHEALTHCUR (TokenQFCaller.ACTOR, "GetArmorShieldHealthCur", ReturnType.FLOAT),
	GETARMORSHIELDHEALTHMAX (TokenQFCaller.ACTOR, "GetArmorShieldHealthMax", ReturnType.FLOAT),
	GETARMORSHIELDHEALTHMAXARMORER (TokenQFCaller.ACTOR, "GetArmorShieldHealthMaxArmorer", ReturnType.FLOAT),
	SEPAR____8(null," ",null),

	GETCROSSHAIRREF (TokenQFCaller.NOTHING, "GetCrosshairRef", ReturnType.REF),
	GETCROSSHAIRACTOR (TokenQFCaller.NOTHING, "GetCrosshairActor", ReturnType.REF),
	GETPLAYERSPELL (TokenQFCaller.NOTHING, "GetPlayerSpell", ReturnType.REF),
	GETPLAYERSPELLCOST (TokenQFCaller.NOTHING, "GetPlayerSpellCost", ReturnType.INT),
	GETPLAYERFAME (TokenQFCaller.NOTHING, "GetPlayerFame", ReturnType.INT),
	GETPLAYERINFAMY (TokenQFCaller.NOTHING, "GetPlayerInfamy", ReturnType.INT),
	GETPLAYERISDETECTED (TokenQFCaller.NOTHING, "GetPlayerIsDetected", ReturnType.BOOL),
	GETAMOUNTSOLDSTOLEN (TokenQFCaller.NOTHING, "GetAmountSoldStolen", ReturnType.INT),
	GETSKILLUPSCUR (TokenQFCaller.NOTHING, "GetSkillUpsCur", ReturnType.INT),
	GETSKILLUPSMAX (TokenQFCaller.NOTHING, "GetSkillUpsMax", ReturnType.INT),
	GETPLAYERSKILLUSEC (TokenQFCaller.NOTHING, "GetPlayerSkillUseC", ReturnType.FLOAT, TokenQFParam.AV_CODE),
	GETREQUIREDSKILLEXPC (TokenQFCaller.NOTHING, "GetRequiredSkillExpC", ReturnType.FLOAT, TokenQFParam.AV_CODE),
	GETPCMISCSTAT (TokenQFCaller.NOTHING, "GetPCMiscStat", ReturnType.MULTI, TokenQFParam.STATS_CODE),
	SEPAR____9(null," ",null),

	GETITEMCOUNT2 (TokenQFCaller.ACTOR_AND_ITEM, "GetItemCount2", ReturnType.INT),
	GETDISPOSITION (TokenQFCaller.ACTOR_AND_ACTOR, "GetDisposition", ReturnType.INT),
	GETSAMEFACTION (TokenQFCaller.ACTOR_AND_ACTOR, "GetSameFaction", ReturnType.BOOL),
	GETINFACTION (TokenQFCaller.ACTOR_AND_FACTION, "GetInFaction", ReturnType.BOOL),
	ISENEMY2 (TokenQFCaller.ACTOR_AND_ACTOR, "IsEnemy2", ReturnType.BOOL),
	SEPAR____10(null," ",null),
	
	GETOV (GETOBJECTVALUE, "GetOV"),
	GETCV (GETCURRENTVALUE, "GetCV"),
	GETEOV (GETEQUIPPEDOBJECTVALUE, "GetEOV"),
	GETECV (GETEQUIPPEDCURRENTVALUE, "GetECV"),
	GETPCMAJORSKILLUPS (GETSKILLUPSCUR, "GetPCMajorSkillUps"),
	;


	public final TokenQFCaller caller;
	public final String name;
	public final ReturnType returnType;
	public final TokenQFParam[] params;

	TokenQF (TokenQFCaller caller, String name, ReturnType returnType, TokenQFParam...params){
		this.caller = caller;
		this.name = name;
		this.returnType = returnType;
		this.params = params;
	}
	
	TokenQF (TokenQF other, String name){
		this(other.caller, name, other.returnType, other.params);
	}

	@Override
	public String toCode(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
