<template>
    <header id="header">
        <div id="logo">
            <p>MailStorm</p>
        </div>
        <div id="page">
           {{name}}
        </div>
        <div id="logOut">
            <button @click="logOUT()" id="out">
                logOut
            </button>
        </div>
    </header>
</template>

<script>
import { mapActions } from 'vuex';
export default {
    props:['name'],
    methods:{
        ...mapActions(['logOutFromSystem']),
        logOUT()
        {
            this.logOutFromSystem();
            this.$router.push({name:'sign-in'});
        }
    }
}
</script>

<style>
#header
{
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #1E3A8A;
    position: fixed;
    top: 0;
    z-index: 100;
    left: 0;
    right: 0;
    height: 60px;
    color:#FFFFFF;
}
#logo img
{
    width: 100px;
    height: 60px;
    object-fit: contain;
  
    
}
#logo
{
    margin-left: 10px;
    color: #F59E0B;
    font-size: 1.5rem;
}

#page
{
    font-size: 1.5rem;
    color:#F59E0B;
}
#logOut
{
    margin-right: 10px;
}
#out
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
  margin-top: 10px;
  margin-bottom: 10px;
}
#out:hover
{
    background-color: #D97706;
}
</style>