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
 * Created on 12.12.2005
 *
 */


package org.plazmaforge.framework.core;

import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


public class LocaleManager implements LocaleConstants {

	
	
	
    public static final String DEFAULT_REGION = EN_REGION;

    public static final String DEFAULT_ADDRESS_VARIANT = SIMPLE_ADDRESS;

    public static final String DEFAULT_NAME_VARIANT = FIRST_LAST;

    private static LocaleManager instance;

    /** Virtual locale */
    private Locale virtualLocale = new Locale(EN_LANGUAGE, EN_COUNTRY);

    private Map familyLocales = new HashMap();

    private Map regionLocales = new HashMap();

    private Map addressVariants = new HashMap();

    private Map nameVariants = new HashMap();

    private String addressVariant;

    private String nameVariant;
    
    
    
    
    

    private LocaleManager() {
	initialize();
    }

    public static LocaleManager getInstance() {
	if (instance == null) {
	    instance = new LocaleManager();
	}
	return instance;
    }

    private void initialize() {

	// Create region associations (family)
	Set set = new HashSet();
	familyLocales.put(EN_COUNTRY, set);

	set = new HashSet();
	familyLocales.put(RU_COUNTRY, set);

	set = new HashSet();
	set.add(new Locale(UK_LANGUAGE, UA_COUNTRY));
	set.add(new Locale(RU_LANGUAGE, UA_COUNTRY));
	set.add(new Locale(RU_LANGUAGE, RU_COUNTRY));
	familyLocales.put(UA_COUNTRY, set);

	regionLocales.put(RU_COUNTRY, XUSSR_REGION);
	regionLocales.put(UA_COUNTRY, XUSSR_REGION);

	// 
	addressVariants.put(DEFAULT_REGION, DEFAULT_ADDRESS_VARIANT);
	addressVariants.put(XUSSR_REGION, COMPLEX_ADDRESS);

	nameVariants.put(DEFAULT_REGION, DEFAULT_NAME_VARIANT);
	nameVariants.put(XUSSR_REGION, LAST_FIRST_MIDDLE);

    }

    public Locale[] getFamilyLocales(String country) {
	Set set = (Set) familyLocales.get(country);
	if (set == null) {
	    return new Locale[0];
	}
	set.add(virtualLocale);
	return (Locale[]) set.toArray(new Locale[0]);

    }

    public static Locale[] getFamilyLocales() {
	Locale locale = Locale.getDefault();
	return getInstance().getFamilyLocales(locale.getCountry());
    }

    public static String getRegion(Locale locale) {
	if (locale == null) {
	    return DEFAULT_REGION;
	}
	String region = (String) getInstance().regionLocales.get(locale
		.getCountry());
	if (region == null) {
	    return DEFAULT_REGION;
	}
	return region;
    }

    /**
     * Get default Locale
     * 
     * @return
     */
    public static Locale getLocale() {
	return Locale.getDefault();
    }

    public static Currency getCurrency() {
	Locale locale = getLocale();
	if (locale == null) {
	    return null;
	}
	try {
	    return Currency.getInstance(locale);
	} catch (Throwable e) {
	    System.err.print("Currency not found. Locale = " + locale.toString());
	    //e.printStackTrace();
	}
	return null;
    }
    
    public static String getRegion() {
	return getRegion(getLocale());
    }
    
    public static boolean isUseLocalityInAddress() {
	return XUSSR_REGION.equals(getRegion());
    }
    
    public static boolean xUSSR() {
	return XUSSR_REGION.equals(getRegion());
    }

    public static String getISO2LanguageByISO3(String iso3) {
	String[] iso3s = getISO3Languages();
	for (int i = 0; i < iso3s.length; i++) {
	    if (iso3.equals(iso3s[i])) {
		return getISO2Languages()[i];
	    }
	}
	throw new IllegalArgumentException("ISO3 code of language not found");
    }

    public static String getISO2CountryByISO3(String iso3) {
	String[] iso3s = getISO3Countries();
	for (int i = 0; i < iso3s.length; i++) {
	    if (iso3.equals(iso3s[i])) {
		return getISO2Countries()[i];
	    }
	}
	throw new IllegalArgumentException("ISO3 code of country not found");
    }

    public static boolean isValidAddressVariant(String addressVariant) {
	if (addressVariant == null) {
	    return false;
	}
	return LocaleManager.SIMPLE_ADDRESS.equals(addressVariant) || LocaleManager.COMPLEX_ADDRESS.equals(addressVariant); 
    }
    
    public static boolean isComplexAddressVariant(String addressVariant) {
	return LocaleManager.COMPLEX_ADDRESS.equals(addressVariant);
    }

    public static boolean isSimpleAddressVariant(String addressVariant) {
	return !isComplexAddressVariant(addressVariant);
    }

    public static boolean isComplexAddressVariant() {
	return LocaleManager.COMPLEX_ADDRESS.equals(LocaleManager.getAddressVariant());
    }

    public static boolean isSimpleAddressVariant() {
	return !isComplexAddressVariant();
    }
    
    public static String getAddressVariant() {
	if (getInstance().addressVariant == null) {
	    getInstance().addressVariant = getAddressVariant(getLocale());
	}
	return getInstance().addressVariant;
    }
    
    

    public static String getAddressVariant(Locale locale) {
	if (locale == null) {
	    return DEFAULT_ADDRESS_VARIANT;
	}
	String region = getRegion(locale);
	String variant = (String) getInstance().addressVariants.get(region);
	return (variant == null) ? DEFAULT_ADDRESS_VARIANT : variant;
    }

    public static String getNameVariant() {
	if (getInstance().nameVariant == null) {
	    getInstance().nameVariant = getNameVariant(getLocale());
	}
	return getInstance().nameVariant;
    }

    public static String getNameVariant(Locale locale) {
	if (locale == null) {
	    return DEFAULT_NAME_VARIANT;
	}
	String region = getRegion(locale);
	String variant = (String) getInstance().nameVariants.get(region);
	return (variant == null) ? DEFAULT_NAME_VARIANT : variant;
    }

    public static String getPersonName(String firstName, String lastName, String middleName) {
	String nameVariant = LocaleManager.getNameVariant();
	String first = normalize(firstName);
	String last = normalize(lastName);
	String middle = normalize(middleName);
	
	if (first == null && last == null && middle == null) {
	    return "";
	}
	StringBuffer buf = new StringBuffer();
	boolean flag = false;
	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    if (last != null) {
		flag = true;
		buf.append(last);
	    }
	    if (first != null) {
		if (flag) {
		    buf.append(" ");
		} else {
		    flag = true;
		}
		buf.append(first);
	    }
	    if (middle != null) {
		if (flag) {
		    buf.append(" ");
		}
		buf.append(middle);
	    }
	    return buf.toString();
	}
	if (first != null) {
	    flag = true;
	    buf.append(first);
	}
	if (last != null) {
	    if (flag) {
		buf.append(" ");
	    }
	    buf.append(last);
	}
	return buf.toString();
    }
	
    private static String normalize(String str) {
	if (str == null) {
	    return null;
	}
	String s = str.trim();
	return (s.length() == 0) ? null : s;
    }

	
   /*
    *
    * @(#)Locale.java	1.68 01/12/03
    *
    * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
    * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
    */
	
    /**
     * Returns a list of all 2-letter country codes defined in ISO 3166.
     * Can be used to create Locales.
     */
    public static String[] getISO2Countries() {
        if (iso2Countries == null) {
            iso2Countries = new String[compressedIsoCountries.length() / 6];
            for (int i = 0; i < iso2Countries.length; i++)
                iso2Countries[i] = compressedIsoCountries.substring((i * 6) + 1, (i * 6) + 3);
        }
        String[] result = new String[iso2Countries.length];
        System.arraycopy(iso2Countries, 0, result, 0, iso2Countries.length);
        return result;
    }

    /**
     * Returns a list of all 2-letter language codes defined in ISO 639.
     * Can be used to create Locales.
     * [NOTE:  ISO 639 is not a stable standard-- some languages' codes have changed.
     * The list this function returns includes both the new and the old codes for the
     * languages whose codes have changed.]
     */
    public static String[] getISO2Languages() {
        if (iso2Languages == null) {
            iso2Languages = new String[compressedIsoLanguages.length() / 6];
            for (int i = 0; i < iso2Languages.length; i++)
                iso2Languages[i] = compressedIsoLanguages.substring((i * 6) + 1, (i * 6) + 3);
        }
        String[] result = new String[iso2Languages.length];
        System.arraycopy(iso2Languages, 0, result, 0, iso2Languages.length);
        return result;
    }
	
	
	
    /**
     * Returns a list of all 3-letter country codes defined in ISO 3166.
     * Can be used to create Locales.
     */
    public static String[] getISO3Countries() {
        if (iso3Countries == null) {
            iso3Countries = new String[compressedIsoCountries.length() / 6];
            for (int i = 0; i < iso3Countries.length; i++)
                iso3Countries[i] = compressedIsoCountries.substring((i * 6) + 3, (i * 6) + 6);
        }
        String[] result = new String[iso3Countries.length];
        System.arraycopy(iso3Countries, 0, result, 0, iso3Countries.length);
        return result;
    }

    /**
     * Returns a list of all 3-letter language codes defined in ISO 639.
     * Can be used to create Locales.
     * [NOTE:  ISO 639 is not a stable standard-- some languages' codes have changed.
     * The list this function returns includes both the new and the old codes for the
     * languages whose codes have changed.]
     */
    public static String[] getISO3Languages() {
        if (iso3Languages == null) {
            iso3Languages = new String[compressedIsoLanguages.length() / 6];
            for (int i = 0; i < iso3Languages.length; i++)
                iso3Languages[i] = compressedIsoLanguages.substring((i * 6) + 3, (i * 6) + 6);
        }
        String[] result = new String[iso3Languages.length];
        System.arraycopy(iso3Languages, 0, result, 0, iso3Languages.length);
        return result;
    }

	
    /**
     * List of all 2-letter language codes currently defined in ISO 639.
     * (Because the Java VM specification turns an array constant into executable code
     * that generates the array element by element, we keep the array in compressed
     * form in a single string and build the array from it at run time when requested.)
     * [We're now also using this table to store a mapping from 2-letter ISO language codes
     * to 3-letter ISO language codes.  Each group of characters consists of a comma, a
     * 2-letter code, and a 3-letter code.  We look up a 3-letter code by searching for
     * a comma followed by a 2-letter code and then getting the three letters following
     * the 2-letter code.]
     */
    private static String[] iso2Languages = null;	
    private static String[] iso3Languages = null;	
    private static final String compressedIsoLanguages =
        ",aaaar,ababk,afafr,amamh,arara,asasm,ayaym,azaze,babak,bebel,bgbul,bhbih,bibis,bnben,"
        + "bobod,brbre,cacat,cocos,csces,cycym,dadan,dedeu,dzdzo,elell,eneng,eoepo,esspa,"
        + "etest,eueus,fafas,fifin,fjfij,fofao,frfra,fyfry,gagai,gdgdh,glglg,gngrn,guguj,"
        + "hahau,heheb,hihin,hrhrv,huhun,hyhye,iaina,idind,ieile,ikipk,inind,isisl,itita,"
        + "iuiku,iwheb,jajpn,jiyid,jwjaw,kakat,kkkaz,klkal,kmkhm,knkan,kokor,kskas,kukur,"
        + "kykir,lalat,lnlin,lolao,ltlit,lvlav,mgmlg,mimri,mkmkd,mlmal,mnmon,momol,mrmar,"
        + "msmsa,mtmlt,mymya,nanau,nenep,nlnld,nonor,ococi,omorm,orori,papan,plpol,pspus,"
        + "ptpor,quque,rmroh,rnrun,roron,rurus,rwkin,sasan,sdsnd,sgsag,shsrp,sisin,skslk,"
        + "slslv,smsmo,snsna,sosom,sqsqi,srsrp,ssssw,stsot,susun,svswe,swswa,tatam,tetel,"
        + "tgtgk,ththa,titir,tktuk,tltgl,tntsn,toton,trtur,tstso,tttat,twtwi,uguig,ukukr,"
        + "ururd,uzuzb,vivie,vovol,wowol,xhxho,yiyid,yoyor,zazha,zhzho,zuzul";

    /**
     * List of all 2-letter country codes currently defined in ISO 3166.
     * (Because the Java VM specification turns an array constant into executable code
     * that generates the array element by element, we keep the array in compressed
     * form in a single string and build the array from it at run time when requested.)
     * [We're now also using this table to store a mapping from 2-letter ISO country codes
     * to 3-letter ISO country codes.  Each group of characters consists of a comma, a
     * 2-letter code, and a 3-letter code.  We look up a 3-letter code by searching for
     * a comma followed by a 2-letter code and then getting the three letters following
     * the 2-letter code.]
     */
    private static String[] iso2Countries = null;	
    private static String[] iso3Countries = null;
    private static final String compressedIsoCountries =
        ",ADAND,AEARE,AFAFG,AGATG,AIAIA,ALALB,AMARM,ANANT,AOAGO,AQATA,ARARG,ASASM,ATAUT,"
        + "AUAUS,AWABW,AZAZE,BABIH,BBBRB,BDBGD,BEBEL,BFBFA,BGBGR,BHBHR,BIBDI,BJBEN,BMBMU,"
        + "BNBRN,BOBOL,BRBRA,BSBHS,BTBTN,BVBVT,BWBWA,BYBLR,BZBLZ,CACAN,CCCCK,CFCAF,CGCOG,"
        + "CHCHE,CICIV,CKCOK,CLCHL,CMCMR,CNCHN,COCOL,CRCRI,CUCUB,CVCPV,CXCXR,CYCYP,CZCZE,"
        + "DEDEU,DJDJI,DKDNK,DMDMA,DODOM,DZDZA,ECECU,EEEST,EGEGY,EHESH,ERERI,ESESP,ETETH,"
        + "FIFIN,FJFJI,FKFLK,FMFSM,FOFRO,FRFRA,FXFXX,GAGAB,GBGBR,GDGRD,GEGEO,GFGUF,GHGHA,"
        + "GIGIB,GLGRL,GMGMB,GNGIN,GPGLP,GQGNQ,GRGRC,GSSGS,GTGTM,GUGUM,GWGNB,GYGUY,HKHKG,"
        + "HMHMD,HNHND,HRHRV,HTHTI,HUHUN,IDIDN,IEIRL,ILISR,ININD,IOIOT,IQIRQ,IRIRN,ISISL,"
        + "ITITA,JMJAM,JOJOR,JPJPN,KEKEN,KGKGZ,KHKHM,KIKIR,KMCOM,KNKNA,KPPRK,KRKOR,KWKWT,"
        + "KYCYM,KZKAZ,LALAO,LBLBN,LCLCA,LILIE,LKLKA,LRLBR,LSLSO,LTLTU,LULUX,LVLVA,LYLBY,"
        + "MAMAR,MCMCO,MDMDA,MGMDG,MHMHL,MKMKD,MLMLI,MMMMR,MNMNG,MOMAC,MPMNP,MQMTQ,MRMRT,"
        + "MSMSR,MTMLT,MUMUS,MVMDV,MWMWI,MXMEX,MYMYS,MZMOZ,NANAM,NCNCL,NENER,NFNFK,NGNGA,"
        + "NINIC,NLNLD,NONOR,NPNPL,NRNRU,NUNIU,NZNZL,OMOMN,PAPAN,PEPER,PFPYF,PGPNG,PHPHL,"
        + "PKPAK,PLPOL,PMSPM,PNPCN,PRPRI,PTPRT,PWPLW,PYPRY,QAQAT,REREU,ROROM,RURUS,RWRWA,"
        + "SASAU,SBSLB,SCSYC,SDSDN,SESWE,SGSGP,SHSHN,SISVN,SJSJM,SKSVK,SLSLE,SMSMR,SNSEN,"
        + "SOSOM,SRSUR,STSTP,SVSLV,SYSYR,SZSWZ,TCTCA,TDTCD,TFATF,TGTGO,THTHA,TJTJK,TKTKL,"
        + "TMTKM,TNTUN,TOTON,TPTMP,TRTUR,TTTTO,TVTUV,TWTWN,TZTZA,UAUKR,UGUGA,UMUMI,USUSA,"
        + "UYURY,UZUZB,VAVAT,VCVCT,VEVEN,VGVGB,VIVIR,VNVNM,VUVUT,WFWLF,WSWSM,YEYEM,YTMYT,"
        + "YUYUG,ZAZAF,ZMZMB,ZRZAR,ZWZWE";
	
	
	
/**
      static {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Class data = Class.forName("java.util.CurrencyData");
                    mainTable = (String) data.getDeclaredField("mainTable").get(data);
                    scCutOverTimes = (long[]) data.getDeclaredField("scCutOverTimes").get(data);
                    scOldCurrencies = (String[]) data.getDeclaredField("scOldCurrencies").get(data);
                    scNewCurrencies = (String[]) data.getDeclaredField("scNewCurrencies").get(data);
                    scOldCurrenciesDFD = (int[]) data.getDeclaredField("scOldCurrenciesDFD").get(data);
                    scNewCurrenciesDFD = (int[]) data.getDeclaredField("scNewCurrenciesDFD").get(data);
                    otherCurrencies = (String) data.getDeclaredField("otherCurrencies").get(data);
                    otherCurrenciesDFD = (int[]) data.getDeclaredField("otherCurrenciesDFD").get(data);
                } catch (ClassNotFoundException e) {
                    throw new InternalError();
                } catch (NoSuchFieldException e) {
                    throw new InternalError();
                } catch (IllegalAccessException e) {
                    throw new InternalError();
                }
                return null;
            }
        });
    }

 */	
}
