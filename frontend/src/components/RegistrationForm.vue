<template>
    <div class="d-flex align-center justify-center" style="height: 30vh">
        <h1>{{header}}</h1>
    </div>
    <div class="d-flex align-center justify-center" style="height: 50vh">
        <v-sheet width="400" class="mx-auto">
            <v-form @submit.prevent="handleRegistration">
                <v-text-field 
                v-model="name" label="Insert name"
                />
                <v-text-field 
                v-model="surname" label="Insert surname"
                />
                <v-text-field 
                v-model="email" label="Insert email"
                />
                <v-text-field 
                v-model="password" label="Insert password"
                />
                <v-text-field 
                v-model="passwordConfirm" label="Repeat password"
                />
                <v-btn 
                type="submit" 
                color="primary" 
                block class="mt-2">
                    Sign to portal
                </v-btn>
            </v-form>
        </v-sheet>
    </div>
  </template>
  
  <script>
  
  export default{
  
    data() {
        return {
            header: 'Registration',
            name: '',
            surname:'',
            email: '',
            password: '',
            passwordConfirm: ''
        };
    },
    methods: {
        handleRegistration(){
            console.log("name", this.name);
            console.log("surname", this.surname);
            console.log("email", this.email);
            console.log("password", this.password);
            console.log("password", this.passwordConfirm);
        }, 
    },
  }
  
  </script>
  