import {createStore} from 'vuex';
//THIS is a single source of truth in vue js
//We will commit user data here and it will be accessible from any part of project
import createPersistedState from 'vuex-persistedstate';    //Uses local storage to persist data
const store= createStore({
    state:{
         user:{
            email:''
         }

    },
    mutations:{
        setUser(state,userData){
           
           state.user.email=userData.email;
        },
        removeUser(state)
        {
            state.user.email='';
        }
    },
    actions:{
       saveUser({commit},userData)
       {
         commit('setUser',userData);
       },
       logOutFromSystem({commit})
       {
          commit('removeUser');
       }
    },
    getters:{
        getUser(state)
        {
            return state.user;
        }
    },
    plugins: [createPersistedState()],

});

export default store;