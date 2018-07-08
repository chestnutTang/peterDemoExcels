/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    /**
     * 保存Preference的name
     */
    public static final String PREFERENCE_NAME = "isfirst";
    private static SharedPreferences mSharedPreferences;
    private static PreferenceHelper mPreferencemManager;
    private static SharedPreferences.Editor editor;

    private PreferenceHelper(Context cxt) {
        mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static synchronized void init(Context cxt) {
        if (mPreferencemManager == null) {
            mPreferencemManager = new PreferenceHelper(cxt);
        }
    }

    /**
     * 单例模式，获取instance实例
     *
     * @return
     */
    public synchronized static PreferenceHelper getInstance() {
        if (mPreferencemManager == null) {
            throw new RuntimeException("please init first!");
        }

        return mPreferencemManager;
    }

    /**
     * @param oss_keyid 保存osskeyid
     */
    public void setOSSKeyId(String oss_keyid) {
        editor.putString("oss_keyid", oss_keyid);
        editor.commit();
    }

    public String getOSSKeyId() {
        return mSharedPreferences.getString("oss_keyid", "");
    }

    /**
     * @param oss_keysecret 保存osskeysecret
     */
    public void setOSSKeySecret(String oss_keysecret) {
        editor.putString("oss_keysecret", oss_keysecret);
        editor.commit();
    }

    public String getOSSKeySecret() {
        return mSharedPreferences.getString("oss_keysecret", "");
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    public void setId(int id) {
        editor.putInt("id", id);
        editor.commit();
    }

    public int getId() {
        return mSharedPreferences.getInt("id", 0);
    }

    public void setToken(String token) {
        editor.putString("token", token);
        editor.commit();
    }

    public String getToken() {
        return mSharedPreferences.getString("token","");
    }

}
