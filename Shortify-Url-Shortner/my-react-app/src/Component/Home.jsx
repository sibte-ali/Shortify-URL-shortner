import React, { useState } from "react";
import { Link } from "react-router-dom";

function Home() {
    const [longUrl,setLongurl] = useState('');
    const [shortUrl,setShorturl]=useState('');
    const postData = {
        "longUrl" : longUrl
    };
     
const URL='http://localhost:8086/short';

    async function createShortUrl(url,data)
    {
        try{
            const response = await fetch(url,{
        method:'POST',
        headers: {
            'Content-Type' : 'application/json; charset=UTF-8',
        },
        body: JSON.stringify(data),
    })

     if(!response.ok)
            {
                throw new Error(`HTTP error ${response.status}` )
            }
            const responseData = await response.json();
            console.log("success" , responseData);
            return responseData;
        }

        catch(error)
        {
            alert("errorrrr hua re !!!!!!!!")
            throw error;
        }
           
            

    }
    const handlesubmit =  async (e) =>{   
        e.preventDefault(); 
        console.log("long url ",postData)
        const response= await createShortUrl(URL,postData)
        setShorturl(response.shortUrl)
        console.log("response ", response)

    console.log("handle submit clicked ", longUrl)
}

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 to-slate-800 text-white">

      {/* Navbar */}
      <nav className="flex justify-between items-center px-10 py-6">
        <h1 className="text-2xl font-bold text-indigo-400">
          Shortify
        </h1>
        <div className="space-x-6 text-gray-300">
        
          <Link to='/About' className="hover:text-white">About</Link>
          <Link to='/Auth' className="hover:text-white">Login</Link>
        </div>
      </nav>

      {/* Hero Section */}
      <section className="flex flex-col items-center text-center mt-24 px-4">
        <h2 className="text-4xl md:text-5xl font-extrabold leading-tight">
          Shorten Your Links <br />
          <span className="text-indigo-400">Share Them Everywhere</span>
        </h2>

        <p className="mt-6 text-gray-400 max-w-xl">
          A fast, secure, and reliable URL shortener to make your links
          simple, clean, and shareable.
        </p>

        {/* Input Box */}
        <div className="mt-10 w-full max-w-2xl flex flex-col md:flex-row gap-4">
            
          <form onSubmit={(e)=>{
            handlesubmit(e);
            }} >
            <input
            type="text"
            placeholder="Paste your long URL here..."
            className="flex-1 px-5 py-4 rounded-lg text-yellow-1300 "
             value={longUrl}
          onChange={(e)=>{
            setLongurl(e.target.value)
            
          }}
          />
          <button className="px-8 py-4 bg-indigo-500 hover:bg-indigo-600 rounded-lg font-semibold transition"
         
          >
            Shorten URL
          </button>
          </form>
          
         <div className="flex-1 px-5 py-4 rounded-lg text-yellow-1300 ">
             {shortUrl}
         </div>

        </div>
      </section>

      {/* Features */}
      <section className="mt-32 px-10">
        <div className="grid md:grid-cols-3 gap-10 text-center">
          <div className="bg-slate-800 p-8 rounded-xl">
            <h3 className="text-xl font-semibold text-indigo-400">
              ⚡ Fast
            </h3>
            <p className="mt-4 text-gray-400">
              Generate short links instantly with low latency.
            </p>
          </div>

          <div className="bg-slate-800 p-8 rounded-xl">
            <h3 className="text-xl font-semibold text-indigo-400">
              🔒 Secure
            </h3>
            <p className="mt-4 text-gray-400">
              Your links are protected with modern security standards.
            </p>
          </div>

          <div className="bg-slate-800 p-8 rounded-xl">
            <h3 className="text-xl font-semibold text-indigo-400">
              📊 Analytics
            </h3>
            <p className="mt-4 text-gray-400">
              Track clicks, locations, and performance in real time.
            </p>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="mt-32 py-8 text-center text-gray-500">
        © 2025 Shortify. All rights reserved.
      </footer>
    </div>
  );
}

export default Home;
