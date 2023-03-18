<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Session;

class AuthManager extends Controller
{
    // making function
    function login(){
      return view('login');
    }

    function registration(){
        return view('registration');
    }
    function loginPost(Request $request){
        $request->validate([
            'email' =>'required ',
            //'password' =>'required|min:6',
            'password' =>'required',

        ]);
        $credentials=$request->only('email', 'password');
        if(Auth::attempt($credentials)){
            return redirect()->intended(route('home'));
        }
        return redirect(route('login'))->with('error', 'login details incorrect');
    }

    function registrationPost(Request $request){
        $request->validate([
            'fullname' =>'required|',
            'email' =>'required|email|unique:users',
            //'password' =>'required|min:6',
            'password' =>'required',

        ]);
        $data['name']=$request->name;
        $data['email']=$request->email;
        $data['password']=Hash::make($request->password);
        $user=User::create($data);

        if(!$user){
            return redirect(route('registration'))->with('error', 'registration failed,Try again!!');
        }
        return redirect(route('registration'))->with('success', 'Resistration success, Login access to app.');
    }

  function logout(){
    Session::fflush();
    Auth::logout();
    return redirect(route('login'));
  }


}
