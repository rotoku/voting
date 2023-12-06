# voting

![Feature Voting App](https://github.com/kumabes-org/voting/actions/workflows/1-Feature-Voting-App.yml/badge.svg)
![Feature Voting Backend](https://github.com/kumabes-org/voting/actions/workflows/1-Feature-Voting-Backend.yml/badge.svg)
![Feature Voting Result](https://github.com/kumabes-org/voting/actions/workflows/1-Feature-Voting-Result.yml/badge.svg)
![Feature Voting Worker](https://github.com/kumabes-org/voting/actions/workflows/1-Feature-Voting-Worker.yml/badge.svg)

## 1. voting-cache
Cache responsável por receber as informações recebidas do formulário

## 2. voting-database
Banco de dados responsável por armazenar a votação

## 3. voting-app
Formulário contento as opções das linguagens na qual o usuário utiliza

## 4. voting-worker
Worker responsável por fazer retrieve do cache e persistir no banco de dados

## 5. voting-result
Página que exibe o resultado sumarizado da votação


### Verificar os votos no pod do redis
```
$ kubectl get pods
NAME                                 READY   STATUS    RESTARTS   AGE
redis-deploy-598c448457-n46l8        1/1     Running   0          25m
voting-app-deploy-54cc59b69b-bp5w8   1/1     Running   0          11s


$ kubectl exec -it redis-deploy-598c448457-n46l8 -- redis-cli
127.0.0.1:6379> KEYS *
1) "\xac\xed\x00\x05t\x00\x05swift"
2) "\xac\xed\x00\x05t\x00\x06csharp"
3) "\xac\xed\x00\x05t\x00\x02go"
4) "\xac\xed\x00\x05t\x00\x04java"
5) "\xac\xed\x00\x05t\x00\x06python"
6) "\xac\xed\x00\x05t\x00\x06kotlin"

127.0.0.1:6379> GET "\xac\xed\x00\x05t\x00\x03cpp"
```

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