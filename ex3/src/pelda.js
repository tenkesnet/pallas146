// 1,2,567,-3,-78
// 1.6, 0.5,-3.6
// true, false
//camelCase motorTerfogatSzam 
//PascalCase MotorTerfogat
//underscore_case motor_terfogat
var terfogat = 50;
var uvegTerfogat = terfogat;
terfogat = 100;
var nev = "Robi";
var terfogatLista = [23, 78, 56.8];
var kutya = terfogatLista;
var alkalmazott = {
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
};
//terfogatLista.push(100)
kutya[0] = 100;
//console.log(nev);
nev = "Józsi";
// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(alkalmazott.utazasai[0].utazasiIroda);
