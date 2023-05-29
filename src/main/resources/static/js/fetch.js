import('node-fetch');

async function fetchData() {
  try {
    let response = await fetch('https://dad-jokes.p.rapidapi.com/random/joke', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'X-RapidAPI-Key': '4fa023a5damshaf3fd7a83ec407ep121da3jsn169b40d856e9',
        'X-RapidAPI-Host': 'dad-jokes.p.rapidapi.com'
      }
    });

    let result = await response.json();
    console.log(result);
  } catch (error) {
    console.error(error);
  }
}

fetchData();




// try {
//     let response = await fetch('https://dad-jokes.p.rapidapi.com/random/joke', {
//         method: 'GET',
//         headers: {
//             'Content-Type': 'application/json',
//             'X-RapidAPI-Key': '4fa023a5damshaf3fd7a83ec407ep121da3jsn169b40d856e9',
//             'X-RapidAPI-Host': 'dad-jokes.p.rapidapi.com'
//           },
//           body: JSON.stringify({
//             _id:'5f80ccd641785ba7c7d27b99',
//             punchline:'Join the club.',
//             setup:'Bad at golf?',
//             type:'general'
//           })
//     })
//     .then(response => {
//         return response.json()
//     })
    
//     ;
// 	let result = await response.text();
// 	console.log(result);
// } catch (error) {
// 	console.error(error);
// }