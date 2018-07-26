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
import android.text.TextUtils;

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

    public int getage() {
        return mSharedPreferences.getInt("age", 0);
    }

    public void setage(int age) {
        editor.putInt("age", age);
        editor.commit();
    }

    public int getId() {
        return mSharedPreferences.getInt("id", 0);
    }

    public void setToken(String token) {
        if (!TextUtils.isEmpty(token)) {
            editor.putString("token", token);
            editor.commit();
        }
    }

    public String getToken() {
        return mSharedPreferences.getString("token", "");
    }

    public void setpassword(String password) {
        if (!TextUtils.isEmpty(password)) {
            editor.putString("password", password);
            editor.commit();
        }

    }

    public String getpassword() {
        return mSharedPreferences.getString("password", "");
    }

    public void setnickName(String nickName) {
        if (!TextUtils.isEmpty(nickName)) {
            editor.putString("nickName", nickName);
            editor.commit();
        }
    }

    public String getnickName() {
        return mSharedPreferences.getString("nickName", "");
    }

    public void setrealName(String realName) {
        if (!TextUtils.isEmpty(realName)) {
            editor.putString("realName", realName);
            editor.commit();
        }
    }

    public String getrealName() {
        return mSharedPreferences.getString("realName", "");
    }

    public void setemail(String email) {
        if (!TextUtils.isEmpty(email)) {
            editor.putString("email", email);
            editor.commit();
        }
    }

    public String getemail() {
        return mSharedPreferences.getString("email", "");
    }

    public void setoccupation(String occupation) {
        if (!TextUtils.isEmpty(occupation)) {
            editor.putString("occupation", occupation);
            editor.commit();
        }
    }

    public String getoccupation() {
        return mSharedPreferences.getString("occupation", "");
    }

    public void setcity(String city) {
        if (!TextUtils.isEmpty(city)) {
            editor.putString("city", city);
            editor.commit();
        }
    }

    public String getcity() {
        return mSharedPreferences.getString("city", "");
    }

    public void setphoneNumber(String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            editor.putString("phoneNumber", phoneNumber);
            editor.commit();
        }
    }

    public String getphoneNumber() {
        return mSharedPreferences.getString("phoneNumber", "");
    }

    public void setprofileImg(String profileImg) {
        if (!TextUtils.isEmpty(profileImg)) {
            editor.putString("profileImg", profileImg);
            editor.commit();
        }
    }

    public String getprofileImg() {
        return mSharedPreferences.getString("profileImg", "");
    }

    public void setprofileUrl(String profileImgUrl) {
        if (!TextUtils.isEmpty(profileImgUrl)) {
            editor.putString("profileImgUrl", profileImgUrl);
            editor.commit();
        }
    }

    public String getprofileImgUrl() {
        return mSharedPreferences.getString("profileImgUrl", "");
    }

}
