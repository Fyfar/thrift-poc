# How to start
`mvn clean compile`

## Server side
Run `Server.java` main class, it will be started on port `5050` by default

## Client side
Client side is `spring shell` application

1. Start `App.java`
2. type `help` to get list of commands
3. to get any result, type `get --cpus 1 --ram 1 --disk 40 --vports 4 --sriov --location "some location"` and press `enter`
4. type `exit` to stop shell (or just press `Ctrl-C`)

> all fields are mandatory, `--sriov` is boolean, so omit it to `false`
