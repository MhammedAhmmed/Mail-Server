<template>
  

  

   <form id="form">
       <div  id="welcomeDiv">
           <img src="../assets/MailStorm.webp" id="image">
           <p class="data" id="welcome">welcome to MailStorm</p>  
           <p class="data">Sign up</p>
           <button class="submit">sign-up</button>
           <p>Already have accout:</p>
           <a href="#" style="margin-top:10px; color:#FFFFFF;">sign in </a>
       </div>

      <div class="vl"></div> 

    <div id="fields">

       <div class="field">
           <label class="data">name: </label>
           <input class="inputs" type="text" required placeholder="ex:Ahmed">
      </div>

       <div class="field">
         <label class="data">e-mail: </label>
         <input class="inputs" type="email" required placeholder="ex:Ahmed@MailStorm.com">
       </div>

       <div class="field">
           <label class="data">Password: </label>
           <input class="inputs" type="password" required placeholder="8-character long at least">
       </div>

       <div class="field">
           <label class="data">re-enter Password: </label>
           <input class="inputs" type="password" required placeholder="must match the above one">
       </div>

      

    </div>   
      
       
       
   </form>


</template>

<script>
export default {

}
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
    width: 600px;    
    margin: auto;
     margin-top:50px ;
    border: 2px solid black;
    border-radius: 10px;
    background-color: #1E3A8A;
    display: flex;  
    
}
.inputs
{
  width: 100%;
  padding: 12px 16px;
  margin: 10px 0;
  border-radius: 8px;
  border: 1px solid #CBD5E1; 
  background-color: #FFFFFF; 
  font-size: 16px;
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
    margin-top:15px ;
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
    margin-top: 20px;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
    margin-left: 20px;
    color: white;
}
#fields
{
    display: flex;
    flex-direction: column;
    margin-left: 20px;
   
}
.vl {
  margin-left: 10px;  
  border-left: 1px solid #FFFFFF;
  justify-self: center;
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

</style>