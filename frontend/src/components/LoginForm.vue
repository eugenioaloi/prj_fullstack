<template>
    <div class="d-flex align-center justify-center" style="height: 10vh">
        <h1>{{header}}</h1>
    </div>
    <div class="d-flex align-center justify-center" style="height: 50vh">
        <v-sheet width="400" class="mx-auto">
            <v-form @submit.prevent="handleLogin">
                <v-text-field 
                v-model="email" label="Insert email"
                />
                <v-text-field 
                v-model="password" label="Insert password"
                />
                <v-btn 
                type="submit" 
                color="primary" 
                block class="mt-2">
                    Login to portal
                </v-btn>
            </v-form>
        <div class="mt-2">
            <p class="text-body-2">Don't have an account? 
              <router-link to="registration">Sign Up</router-link>
            </p>
        </div>
        </v-sheet>
    </div>
  </template>
  
  <script>
  
  export default{
  
    data() {
        return {
          header: 'Login',
          email: '',
          password: '',
        };
    },
    methods: {
        handleLogin(){
            console.log("email", this.email);
            console.log("password", this.password);
        }, 
    },
  }
  
  </script>
  