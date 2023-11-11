# voting

## 1. voting-queue
Fila responsável por receber as informações recebidas do formulário

## 1. voting-cache
Cache responsável por receber as informações recebidas do formulário

## 2. voting-database
Banco de dados responsável por armazenar a votação

## 3. voting-app
Formulário contento as opções das linguagens na qual o usuário utiliza

## 4. voting-worker
- v1: Worker responsável por fazer retrieve do cache e persistir no banco de dados
- v2: Worker responsável por fazer o pool da fila e persistir no banco de dados

## 5. voting-result
Página que exibe o resultado sumarizado da votação


### Environments
- development
- homologation
- production

### troubleshooting com scripts e wrappers
```
cd ./voting-app
ls -lrth ./gradle*
git update-index --chmod=+x ./gradlew
git update-index --chmod=+x ./gradlew.bat
cd ../
git add .
git commit -m "<Message>"
git push
```