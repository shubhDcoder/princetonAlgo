runc() {
    if [ $# -eq 0 ]
        then
            echo "No java file supplied"
    fi
    DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
    classesout="/home/shubhdcoder/GeneralRepo/BitterBit/BitterBit/target/classes/"
    SUB='.java'

    for var in "$@"
    do
        if [[ "$var" == *"$SUB"* ]]
            then
                echo "compiling $var"
                javac -d $classesout -cp $classesout $DIR/$var    
        fi
    done
    echo "************* : compilation finished! : ************"
}

runj() {
    runc $@

    DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
    srcDir="/home/shubhdcoder/GeneralRepo/BitterBit/BitterBit/src/main/java/"
    classesout="/home/shubhdcoder/GeneralRepo/BitterBit/BitterBit/target/classes/"
    filename=$(basename -- "$1")
    srcpath="$DIR/$1"

    package=${srcpath#"$srcDir"}
    suffix=${package%.*}

    if [ $# -eq 2 ]    
        then
            if [ ! -f $classesout/${package%/*}/${2##*/} ]
                then
                    cp $2 $classesout/${package%/*}
                    echo "copied file ${2##*/}"
            else 
                echo "file exists ${2##*/}"
            fi
            echo "running with input file => " ${2##*/}
            java -cp $classesout $suffix $2 > $DIR/${1%.*}"Output.txt"
    else 
        echo "running ${filename}"
        java -cp $classesout $suffix > $DIR/${1%.*}"Output.txt"
    fi
}