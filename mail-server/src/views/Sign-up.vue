<template>

   <form @submit.prevent="handleSubmit" id="form">
  <div id="welcomeDiv">
    
        <p class="data" id="welcome">welcome to MailStorm</p>  
        <p>Already have an account:</p>
        <router-link :to="{name: 'sign-in'}">
            <span style="color:white; text-decoration:underline;">sign-in</span>
        </router-link>
   
   
  </div>


  <div id="fields">
    <div class="field">
      <label class="data">name: </label>
      <input v-model="name" class="inputs" type="text" required placeholder="ex:Ahmed">
    </div>

    <div class="field">
      <label class="data">e-mail: </label>
      <input v-model="email" class="inputs" type="email" required placeholder="ex:Ahmed@MailStorm.com">
      <div class="error" v-if="mailError">{{mailError}}</div>
    </div>

    <div class="field">
      <label class="data">Password: </label>
      <input v-model="password" class="inputs" type="password" required placeholder="8-character long at least">
      <div class="error" v-if="passwordLenError">{{passwordLenError}}</div>
    </div>

    <div class="field">
      <label class="data">re-enter Password: </label>
      <input v-model="Repassword" class="inputs" type="password" required placeholder="must match the above one">
      <div class="error" v-if="passwordConsistencyError">{{passwordConsistencyError}}</div>
    </div>
  </div>
   <button type="submit" class="submit">sign-up</button>
</form>


</template>

<script>
import { mapActions } from 'vuex';
export default {

   data() {
    return {
      name: '',
      email: '',
      password: '',
      Repassword: '',
      mailError: '',
      passwordLenError: '',
      passwordConsistencyError: '',
    };
  },
    methods: {
      ...mapActions(['saveUser']),
       handleSubmit()
       {
           this.passwordConsistencyError=this.password!==this.Repassword?'password must be equal to this field':'';
           this.passwordLenError=this.password.length<8?'password length is smaller than 8':'';
           this.mailError = this.email.includes('@MailStorm') ? '' : 'Email must use @MailStorm domain';
           //TODO:Make sure from backend

                if (!this.passwordConsistencyError && !this.passwordLenError && !this.mailError) {
                            const userData = {
                             email: this.email
                            };
                      this.saveUser(userData);
                      console.log("ok");
                      this.$router.push({name:'Inbox'});
                }
       }

    }

};
</script>

<style scoped>
body
{
    margin: 0;
   
}
p{
    margin: 0;
}
#form{
    text-align: center;
    width: 500px;    
    margin: auto;
     margin-top:10px ;
    border: 2px solid black;
    border-radius: 10px;
    background-color: #1E3A8A;
    display: flex;  
    flex-direction: column;
    justify-content: center;
}
.inputs
{
  width: 100%;
  padding: 10px 12px;
  margin: 2px 0;
  border-radius: 8px;
  border: 1px solid #CBD5E1; 
  background-color: #FFFFFF; 
  font-size: 12px;
  color: #1E3A8A; 
  transition: border 0.3s ease;
}
.data
{
   font-size: 24px;
   color:#FFFFFF;
  text-align: center;
  margin-bottom: 30px;
    
    
}
#welcome
{
    margin-top:5px ;
    text-align: center;
}
.field
{
    margin-top: 10px;
    margin-bottom:10px ;
    margin-left: 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
}
.field:focus
{
    border: 1px solid #3B82F6; 
    outline: none;
}
#image
{
    width: 70px;
    object-fit: contain;
    border-radius:50px ;
    
}
#welcomeDiv
{
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
    align-items: center;
    color: white;
    border-bottom: solid;
}
#fields
{
    display: flex;
    flex-direction: column;
    margin-left: 20px;
   
}
.submit
{
  width: 100%;
  padding: 12px;
  background-color: #F59E0B;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 18px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-top: 20px;
  margin-bottom: 10px;
}
.submit:hover
{
    background-color: #D97706;
}
.error
{
    color: red;
    font-size: 0.8em;
    margin-top:5px;
}

</style>