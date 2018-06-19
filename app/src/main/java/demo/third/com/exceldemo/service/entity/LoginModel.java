package demo.third.com.exceldemo.service.entity;

/**
 * 登录、注册的解析类
 */
public class LoginModel {

    /**
     * code : 0
     * message : success
     * result : {"accountInfo":{"id":7,"password":null,"nickName":null,"age":null,"realName":null,"email":null,"occupation":null,"city":null,"profileImg":null,"phoneNumber":"15621090389"},"token":"53049946961C72DE70380539F07ADA2DBE8B8717CE5A7950850AB3EFB1D4766013C6DE4E5E9F198675EDD530B73457FF5F90EE7E7375E27CE509934265D6A2F17B78C8F93926C747B03C8F53ADC1DA1A"}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * accountInfo : {"id":7,"password":null,"nickName":null,"age":null,"realName":null,"email":null,"occupation":null,"city":null,"profileImg":null,"phoneNumber":"15621090389"}
         * token : 53049946961C72DE70380539F07ADA2DBE8B8717CE5A7950850AB3EFB1D4766013C6DE4E5E9F198675EDD530B73457FF5F90EE7E7375E27CE509934265D6A2F17B78C8F93926C747B03C8F53ADC1DA1A
         */

        private AccountInfoBean accountInfo;
        private String token;

        public AccountInfoBean getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(AccountInfoBean accountInfo) {
            this.accountInfo = accountInfo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class AccountInfoBean {
            /**
             * id : 7
             * password : null
             * nickName : null
             * age : null
             * realName : null
             * email : null
             * occupation : null
             * city : null
             * profileImg : null
             * phoneNumber : 15621090389
             */

            private int id;
            private Object password;
            private Object nickName;
            private Object age;
            private Object realName;
            private Object email;
            private Object occupation;
            private Object city;
            private Object profileImg;
            private String phoneNumber;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public Object getNickName() {
                return nickName;
            }

            public void setNickName(Object nickName) {
                this.nickName = nickName;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getOccupation() {
                return occupation;
            }

            public void setOccupation(Object occupation) {
                this.occupation = occupation;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getProfileImg() {
                return profileImg;
            }

            public void setProfileImg(Object profileImg) {
                this.profileImg = profileImg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }
    }
}
