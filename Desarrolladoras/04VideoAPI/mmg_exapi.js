//Selecting the file
function fileSelected() {
    const files = document.getElementById('uploadedVideo').files;
    if (files.lenght <= 0) {
        alert("Seleccione un archivo");
        return;
    }
    return files[0];
}


//Validation
if(window.File && window.FileReader && window.FileList){
    console.log("Todas las APIs soportadas");
} else {
    alert("La API no es soportada en este navegador.");
}

let supportedTypes = ["video/mp4", "video/ogg", "video/webm"];

function validation(uploadedVideo){
    if (!supportedTypes.includes(uploadedVideo.type)){
        alert('Debe introducir un video en formato mp4, ogg o webm.');
                    throw 'validationError';
    } 
}


//Media and buttons
function creationMedia(uploadedVideo, media){
    var video = document.createElement("video");
    video.id = "video";
    media.appendChild(video);

    var reader = new FileReader();
    reader.onloadstart = function(){
        let status = document.createElement("p");
        status.id = "status";
        status.innerText = "Cargando...";
        media.appendChild(status);
    }
    reader.onloadend = function(){
        video.src = reader.result;
        document.getElementById("status").innerText = "Cargado";
    }
    reader.readAsDataURL(uploadedVideo);

    //Buttons
    var buttons = document.getElementById("buttons");

    //Button Play
    var playButton = document.createElement("button");
    playButton.onclick = () => video.play()
    playButton.innerText = "Reproducir";
    buttons.appendChild(playButton);

    //Button Pause
    var pauseButton = document.createElement("button");
    pauseButton.onclick = () => video.pause()
    pauseButton.innerText = "Pausa";
    buttons.appendChild(pauseButton);

    //Button Repeat
    var repeatButton = document.createElement("button");
    repeatButton.onclick = function(){
        video.loop = true;
    }
    repeatButton.innerText = "Volver a ver";
    buttons.appendChild(repeatButton);

    //Button Mute
    var muteButton = document.createElement("button");
    muteButton.onclick = function(){
        if (video.muted == false){
            video.muted = true;
        } else {
            video.muted = false;
        }
    }
    muteButton.innerText = "Silenciar";
    buttons.appendChild(muteButton);
        
    //Button Turn Up Volume
    var upVolumeButton = document.createElement("button");
    upVolumeButton.onclick = function(){
        video.volume += 0.1;
    }
    upVolumeButton.innerText = "Subir volumen";
    buttons.appendChild(upVolumeButton);
    
    //Button Turn Down Volume
    var downVolumeButton = document.createElement("button");
    downVolumeButton.onclick = function(){
        video.volume -= 0.1;
    }
    downVolumeButton.innerText = "Bajar volumen";
    buttons.appendChild(downVolumeButton);
}


//Delete all when there is an error or Button "Borrar" is pressed
function deleteAll(){
    let media = document.getElementById("media");
    let buttons = document.getElementById("buttons");
    removeChildren(media);
    removeChildren(buttons);
}


//Removing Children
function removeChildren(element){
    element.innerHTML = '';
}


//Upload button
function process(){
    try{
        let media = document.getElementById("media");
        let uploadedVideo = fileSelected();
        validation(uploadedVideo);
        deleteAll();
        creationMedia(uploadedVideo, media);
    } catch (error){
        deleteAll();
    }
}