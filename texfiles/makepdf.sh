pdflatex -shell-escape -output-directory .. jjj-os
cd ..
makeindex jjj-os
cd -
pdflatex -output-directory .. jjj-os
pdflatex -output-directory .. jjj-os
