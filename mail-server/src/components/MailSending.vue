<template>
  
       <form @submit.prevent="handleSending" id="form" >
          <div id="welcomeDiv">
            <img src="../assets/MailStorm.webp" id="image"> 
          </div>
          <div id="fields">
            
                <div class="field">
                <label>to : </label>
                <input v-model="senders" type="text" placeholder="separate by space if multiple receivers" required class="inputs">
            </div>
            <div class="field">
                <label>subject :</label>
                <input v-model="subject" type="text" required class="inputs">
            </div>
            <div class="field">
                <label>body :</label>
                <input v-model="body" type="text" required class="inputs">
            </div>

          </div>
          
          <div id="additions">
              <div>
                <label for="priority">Priority: </label>
                   <select style="width:40%;" id="priority" v-model="priority">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="4">5</option>
                </select>
              </div>
              <div>
                     <!-- we will add attachments here -->
              </div>
          </div>

          <button id="submit">SUBMIT</button>
       </form>


</template>

<script>
import { mapGetters } from 'vuex';
export default {
    
 data() {
    return {
      senders:null,
      From:null,
      priority:1,
      subject:null,
      body:null
    };
  },
    methods: {
        ...mapGetters(['getUser']),
       handleSending()
       {
           this.From=this.getUser().email;
           let sendersArray=this.senders.split(' ');
           sendersArray=sendersArray.filter((e)=>e!=='');
           let Mail={
            from:this.from,
            to:sendersArray,
            subject:this.subject,
            body:this.body,
            priority:this.priority,
            attachments:null
           };
          ///TODO:Push to backend
       }

    }
}
</script>

<style>
label
{
    font-size: 1.5rem;
}
#form{
    text-align: center;
    width: 600px;    
    margin: auto;
    margin-top:200px ;
    border: 2px solid black;
    border-radius: 10px;
    background-color: #1E3A8A;
    display: flex;  
    flex-direction: column;
    
}
#welcomeDiv
{
    font-size: 1.2rem;
    color:white;
    display: flex;
    flex-direction: column;
    margin-bottom: 10px;
    border-bottom: white 1px solid;
}
#image
{
    width: 70px;
    object-fit: contain;
    border-radius:50px ;
}
#welcome{
    margin-left: 40px;
}
.field
{
    margin-top: 10px;
    margin-bottom:10px ;
    margin-left: 10px;
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
}
.field:focus
{
    border: 1px solid #3B82F6; 
    outline: none;
}
#fields
{
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-left: 20px;
}
.inputs
{
  width: 100%;
  padding: 10px 10px;
  margin: 10px 0;
  border-radius: 8px;
  border: 1px solid #CBD5E1; 
  background-color: #FFFFFF; 
  font-size: 12px;
  color: #1E3A8A; 
  transition: border 0.3s ease;
}
#submit
{
  width: 100%;
  padding: 12px;
  background-color: #F59E0B;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-top: 15px;
  margin-bottom: 10px;
}
#submit:hover
{
    background-color: #D97706;
}
</style>