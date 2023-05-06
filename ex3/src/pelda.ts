// 1,2,567,-3,-78
// 1.6, 0.5,-3.6
// true, false
//camelCase motorTerfogatSzam 
//PascalCase MotorTerfogat
//underscore_case motor_terfogat
let terfogat: number = 50;
let uvegTerfogat: number = terfogat;
terfogat = 100;
let nev: String = "Robi"
let terfogatLista: number[] = [23, 78, 56.8]
let kutya = terfogatLista

let alkalmazott = {
    "nev": "Robi",
    "utazasai": [
        {
            cel: "Budapest",
            tavolsag: 550
        },
        {
            cel: "Korfu",
            "utazasiIroda": "Valami Travel",
            "tavolsag": 3400
        }
    ]
}

//terfogatLista.push(100)
kutya[0] = 100
//console.log(nev);
nev = "Józsi"

// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(alkalmazott.utazasai[0].utazasiIroda);