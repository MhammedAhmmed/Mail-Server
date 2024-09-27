import {createStore} from 'vuex';
//THIS is a single source of truth in vue js
//We will commit user data here and it will be accessible from any part of project

export const store= createStore({
    state:{
         user:{
            email:''
         }

    },
    mutations:{
        setUser(state,userData){
           
           state.user.email=userData.email;
        }
    },
    actions:{
       saveUser({commit},userData)
       {
         commit('serUser',userData);
       }
    },
    getters:{
        getUser(state)
        {
            return state.user;
        }
    }



});

