# Building from PreTeXt

First `pip install pretextbook` This installs all the prerequisites needed to build a PreTeXt book.

New instructions: From the main folder, run:
       pretext build html
       pretext view html
       
In your browser, go to:
   http://localhost:8000/

Old instructions: from the pretext folder run `pretext build  -f html -o ../build/html/ -i main.ptx` or you can run from the top level adjusting the paths.
