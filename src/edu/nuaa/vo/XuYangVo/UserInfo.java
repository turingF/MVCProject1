package edu.nuaa.vo.XuYangVo;

	public class UserInfo {
        private  int id;  //主键：用户ID
        private  String account; //电话,作为登录识别号码
        private  String password; // 密码



        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }

}

