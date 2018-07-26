package demo.third.com.exceldemo.service.entity;

/**
 * 登录、注册的解析类
 */
public class LoginModel {

    /**
     * code : 0
     * message : success
     * result : {"accountInfo":{"id":42,"password":"小曼","nickName":"小曼","age":18,"realName":"大猫",
     * "email":"qjcjdjd@126.com","occupation":"你猜","city":"青岛","profileImg":"小曼",
     * "phoneNumber":"15621068991"},
     * "token":"53049946961C72DE70380539F07ADA2DFD4A03CABA7CBEB8DFA7C4840E8D65FB128DA9BA38B6D225CA5F3A365D8CC66C471D36F7FB163C04D5D4E7D2EBBB05D7EA5468EFC0D7698AC89563DA91B4B547"}
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
         * accountInfo : {"id":42,"password":"小曼","nickName":"小曼","age":18,"realName":"大猫",
         * "email":"qjcjdjd@126.com","occupation":"你猜","city":"青岛","profileImg":"小曼",
         * "phoneNumber":"15621068991"}
         * token :
         * 53049946961C72DE70380539F07ADA2DFD4A03CABA7CBEB8DFA7C4840E8D65FB128DA9BA38B6D225CA5F3A365D8CC66C471D36F7FB163C04D5D4E7D2EBBB05D7EA5468EFC0D7698AC89563DA91B4B547
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
             * id : 42
             * password : 小曼
             * nickName : 小曼
             * age : 18
             * realName : 大猫
             * email : qjcjdjd@126.com
             * occupation : 你猜
             * city : 青岛
             * profileImg : 小曼
             * phoneNumber : 15621068991
             */

            private int id;
            private String password;
            private String nickName;
            private int age;
            private String realName;
            private String email;
            private String occupation;
            private String city;
            private String profileImg;
            private String phoneNumber;
            private String profileImgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getProfileImg() {
                return profileImg;
            }

            public void setProfileImg(String profileImg) {
                this.profileImg = profileImg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getProfileImgUrl() {
                return profileImgUrl;
            }

            public void setProfileImgUrl(String profileImgUrl) {
                this.profileImgUrl = profileImgUrl;
            }
        }
    }
}