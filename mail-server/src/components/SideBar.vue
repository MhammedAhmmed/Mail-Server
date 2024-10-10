<template>
  <aside>
    <router-link class="link" :to="{name:'Inbox'}">
      <i class="fas fa-inbox"></i>
      <p>Inbox</p>
    </router-link>

    <router-link class="link" :to="{name:'Sent'}">
      <i class="fas fa-paper-plane"></i> 
      <p>Sent</p>
    </router-link>

    <router-link class="link" :to="{name:'Trash'}">
      <i class="fas fa-trash"></i> 
      <p>Trash</p>
    </router-link>

    <router-link class="link" :to="{name:'Draft'}">
      <i class="fas fa-edit"></i> 
      <p>Draft</p>
    </router-link>

    <router-link class="link" :to="{name:'Contacts'}">
      <i class="fas fa-address-book"></i>
      <p>Contacts</p>
    </router-link>
   <router-link class="link" :to="{name:'Folders'}">
      <i class="fas fa-folder"></i>
      <p>Folders</p>
    </router-link>
  </aside>
</template>

<script>
export default {
   methods:{
    AddFolder()
    {
        //Add new Folder  //TODO
    }
   }
}
</script>

<style>
aside
{
    position: fixed;
    left: 0;
    bottom: 0;
    width: 120px;
    top: 60px;
    background-color: #1E3A8A;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
     color: #FFFFFF;
    
    
}
.RLink
{
    width: 100%;
    border-bottom: 1px solid black;
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: center;
   

}
.link
{
    color: #FFFFFF;
    font-size: 1.2rem;
    text-decoration: none;
    width: 100%;
    border-bottom: 1px solid black;
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    cursor: pointer;
}
</style>