package com.nerfherder.bluetoothgooglenow;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


public class BluetoothGoogleNow implements IXposedHookLoadPackage  {

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

    	if (!"com.android.bluetooth".equals(lpparam.packageName))
            return;

    	//getLastDialledNumber in the class AtPhonebook is only called when bluetooth is requesting a redial
    	
    	findAndHookMethod("com.android.bluetooth.hfp.AtPhonebook", lpparam.classLoader, "getLastDialledNumber", new XC_MethodReplacement() {
      		@Override
    		protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {  	

				return null;
    			
    		}
    	});

    }
}